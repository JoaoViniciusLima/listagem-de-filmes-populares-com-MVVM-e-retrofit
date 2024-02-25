# listagem de filmes populares com MVVM e retrofit
Aplicativo android que lista e exibe os detalhes de filmes populares, utlilizando retrofit e padrão de arquitetura MVVM

## Funcionamento
O aplicativo faz uma requisição via Retrofit para a API, a fim de receber os filmes, que são divididos em páginas na API. Em seguida, ele faz uma listagem de cards com RecyclerView utilizando os dados obtidos. Ao clicar em um card, o usuário é redirecionado para uma nova página que exibe os detalhes do filme. Quando o RecyclerView chega ao fim, o aplicativo faz uma nova requisição para a próxima página na API e exibe uma barra de progresso enquanto a requisição é feita. Quando a requisição é finalizada, os novos dados obtidos são adicionados ao RecyclerView.

## Tecnologias e bibliotecas utilizadas
- retrofit
- okhttp3
- recycleview
- Glide
- gson

## Features
- paginação
- tratamento de erro
- listagem
- Exibição de detalhes ao clicar no card

## Arquitetura
Foi utilizado padrão de arquitetura MVVM com LiveData e repository

## Api utilizada
O aplicativo utiliza a api do The Movie Database

## Screenshots
<img src="https://github.com/JoaoViniciusLima/listagem-de-filmes-populares-com-MVVM-e-retrofit/assets/87715417/e24019fc-7bdd-47e5-ab82-a41337924498" alt="detalhes" width="350"/>
<img src="https://github.com/JoaoViniciusLima/listagem-de-filmes-populares-com-MVVM-e-retrofit/assets/87715417/8631d042-02a9-46d2-ae57-4082dfe5aa0c" alt="listagem" width="350"/>

https://github.com/JoaoViniciusLima/listagem-de-filmes-populares-com-MVVM-e-retrofit/assets/87715417/855556c9-5b7d-4bc0-9264-1157d21bf81e


