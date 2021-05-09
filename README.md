# FicticiusClean

### 🎲 Rodando a aplicação

```bash
# Clone este repositório
$ git clone <https://github.com/CharlesTuan/FicticiusClean.git>

# Instalando o java
sudo apt-get install oracle-java8-installer

# Execute esse comando na pasta core do projeto
mvn clean package install

# Ainda dentro da pasta core execute o comando abaixo para rodar o servidor da aplicação
mvn spring-boot:run

# Visualizando a aplicação
Abra qualquer navegador e digite "http://localhost:8080/", a porta (8080) pode variar caso sua porta já esteja ocupada, por favor observe quando o comando
anterior diz a porta em que foi iniciado "Tomcat initialized with port(s): 8080 (http)"
