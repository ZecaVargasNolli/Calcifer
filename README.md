# Calcifer

# Equipe
Giancarlo Pandini, José Vargas Nolli

# Problema 
   Analizador de texto indicando se o mesmo expressa teor negativo ou possitivo, em seu contexto.

# Dataset 
   Os Modelos da API utilizada, já estavam pré-treinados, porem o dataset utilizado para validação foi http://ai.stanford.edu/~amaas/data/sentiment/

# Técnica

   O projeto tem como objetivo, a partir de um texto digitado pelo usuário, definir se o sentimento presente no texto, se ele é positivo, negativo ou neutro. O sistema utilizará a API Stanford CoreNLP, e irá fazer a análise por setenças presentes no texto, tambem em conjunto tambem apresenterá a procentagem do texto que se encaixa em cada um dos pontos avaliados.

# 1.Análise de Sentimento:
   Também conhecida como mineração de opinião, tem como base processar um texto e extrair deles o conteúdo emocional presente nas palavras do texto, e esse processo pode ser utilizado para obter atitudes, ideias ou pensamentos expressos pela pessoa que redigiu o texto. Porem este tipo de tratamento enfrenta uma série de dificuldades, como por exemplo ao analisar frases sarcasticas, que podem fazer com que uma interpretação que deveria ser negativa acaba sendo definida como positiva.
   "Imagine a mesma situação inicial, sua empresa acabou de lançar um novo produto e automaticamente é possível classificar a opinião dos consumidores e entender o quanto satisfeitos estão e quais são os pontos fracos, os comentários mais negativos e positivos, quais foram mais repercutidos e qual o assunto mais comentado em relação ao lançamento, tudo isso é possível através da Análise de Sentimentos"(Vicente).
   É possível utilizar funções como essa para obter insight referêntes a aceitação dos usuários a respeito dos resultados.
  
# 2.Stanford CoreNLP

   Uma das principais ferramentas quando se referismos a gerar dados com base na analise de sentimento.
   "CoreNLP is your one stop shop for natural language processing in Java! CoreNLP enables users to derive linguistic annotations for text, including token and sentence boundaries, parts of speech, named entities, numeric and time values, dependency and constituency parses, coreference, sentiment, quote attributions, and relations. CoreNLP currently supports 6 languages: Arabic, Chinese, English, French, German, and Spanish."(Stanford)
   No Projeto será utilizado somente os modelos disponibilizados com treinamento em inglês.

# 3.Processamento de Linguagem Natural

   O processamento de linguagem natural é uma abordagem que consistê em possibilitar uma comunicação entre humano e máquina, permitindo a interpretançaõ de texto de construção mais complexa pelo sistema ao converter o texto em uma série de interpretações lógicas. Exemplos comuns da utilização dessa aréa a inteligência artificial seriam: chatbots, a tradução de textos entre linguás diferentes, a conversão de textos em aúdios e de aúdios em textos, a sumarização de texto, a mineração de sentimneto entre outros processos.

# 4.Árvore de Dependência
   Uma àvore de dependência é uma formatação onde a existÊncia de um ramo dependente está obrigtóriamente ligada ao ramo independente ou superior, enquanto o ramo independente pode existir sem a presença de seu ramo dependente.

![jfk-1961](https://user-images.githubusercontent.com/43889995/113495262-ace42380-94c6-11eb-9396-6bda69b26170.png)
fonte:https://cloud.google.com/natural-language/docs/morphology
   
   Como podemos ver, cada elemento está diretamente ligado ao seu dependente ao qual ele influência e alterar o sentido. E o nó root da árvore representa o principal verbo da  e base inicial do sentido da sentença análisada.

# 5.Diagrama de Classes/Pacote do Projeto

![Seguencia CLiente Servidor (1)](https://user-images.githubusercontent.com/43889995/113496775-6943e680-94d3-11eb-9c23-c2cbc9d28fb5.jpeg)
Fonte: Elaborado pelo autor.

   O sistema possui 3 componentes importantes, a tela cosiste na interface de comunicação do  usuário final com a API e a geração de dados, o controller tem somente a função de trânsferir os dados entre a cama da API e da Tela, não aplicando nenhum tratamento direto nos dados exceto manipulações relacionadas a apresentação dele na tela. a API é a responsável por todo o processamento do texto
   
# 6.Diagrama de Seguência

![Diagrama em branco (1)](https://user-images.githubusercontent.com/43889995/113496602-a60ede00-94d1-11eb-8aa8-70e1e29975ad.jpeg)
Fonte: Elaborado pelo autor.

   O Diagrama acima exemplifica o processamento base do projeto que consiste em  inicialmente capturar os dados preenchidos na tela ao usuário clicar no botão analizar, após isso o testo é enviado para o controller que fara a função de chamar a API e obter as informações calculadas pela mesma.Será apresentado ao usuário os seguintes resultados:
  porcentagem do texto com sentimento negativo, porcentagem do texto com sentimento positivo, porcentagem do texto que é inconclusivo(neutro) e por fim o resultado final definido.

# Referência

(Vicente)
Vicente, Eduarda. Análise de Sentimentos, uma aplicação da Inteligência Artificial que avalia o comportamento do seu público, https://www.programmers.com.br/blog/analise-de-sentimentos-uma-aplicacao-da-inteligencia-artificial-que-avalia-o-comportamento-do-seu-publico/ acessado em: 03 de abril de 2021.
(Stanford)

CoreNLP, CoreNLP, https://stanfordnlp.github.io/CoreNLP/index.html, acessado em: 03 de Abril de 2021
