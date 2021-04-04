package Controller;

import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.CoreSentence;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import java.util.List;
import java.util.Properties;

/**
 * 
 * @author Giancarlo
 */
public class SentimentAnalyser {

    public final int SENTIMENTO_POSITIVO = 1;
    public final int SENTIMENTO_NEUTRO = 0;
    public final int SENTIMENTO_NEGATIVO = -1;
    
    public final String SENTIMENTO_POSITIVO_TEXTO = "Positivo";
    public final String SENTIMENTO_NEUTRO_TEXTO = "Neutro";
    public final String SENTIMENTO_NEGATIVO_TEXTO = "Negativo";

    private final int SENTIMENTO_MUITO_POSITIVO = 2;
    private final int SENTIMENTO_MUITO_NEGATIVO = -2;

    private final String PROPERTIES_NAMES = "tokenize, ssplit, pos, parse, sentiment";

    private Properties properties;
    private StanfordCoreNLP stanfordCoreNLP;

    private String textToProcess;
    private double scoreSentiment;
    private double scoreSentimentNegativo;
    private double scoreSentimentPositivo;
    private double scoreSentimentNeutro;
    private double scoreSentimentTotal;

    /* Singleton */
    private static SentimentAnalyser me;

    private SentimentAnalyser() {
        this.properties = new Properties();
        this.properties.setProperty("annotators", this.PROPERTIES_NAMES);
        this.stanfordCoreNLP = new StanfordCoreNLP(this.properties);
        this.scoreSentiment = 0;
        this.scoreSentimentNegativo = 0;
        this.scoreSentimentPositivo = 0;
        this.scoreSentimentNeutro = 0;
        this.scoreSentimentTotal = 0;
        
    }

    public static SentimentAnalyser getInstace() {
        if (SentimentAnalyser.me == null) {
            SentimentAnalyser.me = new SentimentAnalyser();
        }

        return SentimentAnalyser.me;
    }

    public void setTextToProcess(String txt) {
        this.textToProcess = txt;
    }

    public void process() {
        this.scoreSentiment = 0;
        this.scoreSentimentNegativo = 0;
        this.scoreSentimentPositivo = 0;
        this.scoreSentimentNeutro = 0;
        this.scoreSentimentTotal = 0;
        
        CoreDocument coreDoc = new CoreDocument(this.textToProcess);
        this.stanfordCoreNLP.annotate(coreDoc);

        List<CoreSentence> sentences = coreDoc.sentences();
        for (CoreSentence sentence : sentences) {
            String sentimentLower = sentence.sentiment().toLowerCase();
            this.incrementScore(sentimentLower);
        }
    }
    
    public String getSentimento() {
        if (this.scoreSentiment > 0) {
            return this.SENTIMENTO_POSITIVO_TEXTO;
        }
        else if (this.scoreSentiment < 0) {
            return this.SENTIMENTO_NEGATIVO_TEXTO;
        }
        else {
            return this.SENTIMENTO_NEUTRO_TEXTO;
        }
    }
    
    public double getPorcentagemSentimentoPositivo() {
       return (this.scoreSentimentPositivo / this.scoreSentimentTotal) * 100;
    }
    
    public double getPorcentagemSentimentoNegativo() {
       return (this.scoreSentimentNegativo / this.scoreSentimentTotal) * 100;
    }
    
    public double getPorcentagemSentimentoNeutro() {
       return (this.scoreSentimentNeutro / this.scoreSentimentTotal) * 100;
    }
    

    private void incrementScore(String sentiment) {
        if (sentiment.contains("positive")) {
            if (sentiment.contains("very")) {
                this.scoreSentiment += this.SENTIMENTO_MUITO_POSITIVO;
            } 
            else {
                this.scoreSentiment += this.SENTIMENTO_POSITIVO;
            }
            this.scoreSentimentPositivo++;
        } 
        else if (sentiment.contains("negative")) {
            if (sentiment.contains("very")) {
                this.scoreSentiment += this.SENTIMENTO_MUITO_NEGATIVO;
            } 
            else {
                this.scoreSentiment += this.SENTIMENTO_NEGATIVO;
            }
            this.scoreSentimentNegativo++;
        }
        else if (sentiment.contains("neutral")) {
            this.scoreSentiment += this.SENTIMENTO_NEUTRO;
            this.scoreSentimentNeutro++;
        }
        this.scoreSentimentTotal++;
    }
}