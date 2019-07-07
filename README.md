# API para controle e automação de recepção de arquivos de adquirentes

## Descrição e funções

  Esta API tem por finalidade prover as funções necessárias para o funcionamento tanto do upload do arquivo pela adquirente, quanto pelo funcionamento da aplicação web e futuramente um aplicativo mobile, já que eles são desacoplados.  
  A abordagem para solucionar o problema de automação foi deixar com que os arquivos enviados pelos adquirentes sejam automáticamente aceitos pelo sistema (caso os mesmos não tenham erro) e já são considerados para as estatísticas de recepção, porém, seus estados estarão como "Esperando", sendo de fácil visualização pelos operadores.  
  Caso um arquivo não esteja adquado, a operação pode mudar o estado para "Rejeitado" e este não será considerado mais para as estatísticas. Para evitar retrabalho, há também o estado "Aprovado" para a operação saber que um dado arquivo já foi verificado.
  Caso haja a necessidade de download(backup) dos arquivos, há a função de gerar o arquivo e baixa-lo novamente  

O sistema conta com:
* Listagem, cadastro e exclusão de adquirente;
* Listagem, cadastro e exclusão de clientes;
* Listagem, cadastro e exclusão de contratos(vinculo entre cliente e adquirente);
* Upload e download de arquivos e gerenciamento dos mesmos (listagem e modificação do estado);
* Estatisticas sobre a recepção de arquivos de cada adquirente que tenha algum contrato.

 > Todas as requisições da API podem ser encontradas nesse documento [Requisições API Recepção](https://documenter.getpostman.com/view/3660462/SVSDQXGU?version=latest)

## Como executar

##### IDE
```
* Clone ou faça download do projeto
* Na sua IDE importe o projeto como um projeto Spring Boot
* Execute o projeto
* Tudo pronto para usar!
```
> Utilize a branch master para execução do código mais estável*

##### Maven
```
* Clone ou faça download do projeto
* Navegue até a pasta onde o pom.xml se encontra cd/adquirer-control-api
* Execute o seguinte comando: mvn package && java -jar target/gs-spring-boot-0.1.0.jar
* Caso ja tenho utilizado esse comando anteriormente, utilize java -jar target/gs-spring-boot-0.1.0.jar para executar a aplicação *
* Tudo pronto para usar!
```
> Utilize a branch master para execução do código mais estável*
