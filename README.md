# SOCTest Server

Servidor de testes desenvolvido para simular e validar integrações de sistemas.  
O projeto foi criado como parte de um teste técnico e posteriormente atualizado para versões mais recentes das dependências Java.

## 📦 Tecnologias

- Java 21
- Maven
- Struts 7.1.1
- Jetty 11.0.26
- JSP
- SOAP / JAX-WS

## 🚀 Objetivo

O objetivo deste projeto é fornecer um servidor simples capaz de:

- simular endpoints de serviços
- validar integrações
- servir como ambiente de testes para aplicações cliente
- demonstrar atualização de dependências em aplicações Java legadas

O projeto também foi atualizado para rodar em versões modernas do Java mantendo compatibilidade com tecnologias mais antigas como Struts.

## 📂 Estrutura do Projeto

```
src/
  └── main
     ├── java        # código fonte
     ├── resources   # arquivos de configuração e i18n
     └── webapp      # JSP, WEB-INF e configurações web
```

## ⚙️ Como executar

Clone o repositório:

```
git clone https://github.com/denisbenjamim/soctest-server.git
```

Entre na pasta do projeto:

```
cd soctest-server
```

Compile o projeto:

```
mvn clean package
```

Execute com Jetty:

```
mvn jetty:run
```

A aplicação ficará disponível em:

```
http://localhost:8080/soctest
```

## 🔧 Build

Para gerar o artefato:

```
mvn clean package
```

O arquivo `.war` será gerado em:

```
target/
```

## 🌐 Endpoints

Os endpoints SOAP podem ser acessados através do WSDL:

```
http://localhost:8080/soctest/soap/<endpoint>?wsdl
```

## 🧪 Desenvolvimento

Este projeto foi utilizado para:

- atualização de dependências antigas
- modernização de aplicações Java legadas
- experimentação com frameworks web clássicos

## 📄 Licença

Este projeto está disponível apenas para fins educacionais e demonstração.