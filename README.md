# oc-escalade
Comment Déployer l'application

                              1 – Téléchargement des logiciels et installation :

Pour déployer l’application nous allons avoir besoin des quelques logiciels suivants :
Java, Apache Tomcat, Apache Maven, PostgreSQL, PGadmin, Squirrel SQL

1.1 Java
Pour commencer nous allons télécharger et installer java : https://www.java.com/fr/download/

1.2 Apache Maven
A présent nous allons télécharger et installer Apache Maven : https://maven.apache.org/download.cgi

1.3 Apache Tomcat
Dans cette partit nous allons télécharger et installer Apache Tomcat :
https://tomcat.apache.org/download-90.cgi

1.4 PostgreSQL
Nous allons télécharger et installer PostgreSQL :
https://www.enterprisedb.com/downloads/postgres-postgresql-downloads

1.5 PGadmin
Nous allons télécharger et installer PGadmin :
https://www.pgadmin.org/download/

1.6 Squirrel Sql
Nous allons télécharger et installer Squirrel Sql :
https://sourceforge.net/projects/squirrel-sql/files/1-stable/3.9.1/squirrel-sql-3.9.1-standard.jar/download

                                    2 - Déployer la base de données
                                    
Lancer PGadmin et creer la base de donnée "escalade" puis vous entrez le script qui est dans le dossier dans le dossier.

                                    3 - Déployer le jeu de données
                                   
Lancer Squirrel Sql, connecter vous a la base de données. Puis, vous ouvrez et lancez le jeu de données qui est dans le dossier.

                                     4 – Déployer l’application
                                 
Lancer l'application grace a un IDE.

4.1 - Empaquetage
                                            
Dans le terminal de l'IDE, saisissez la commande suivante "mvn package".
Le fichier War se trouve dans oc-escalade/oc-escalade-webapp/target.
Copiez le.

4.2 - Deployer l'application avec Apache Tomcat

Collez le fichier WAR dans le dossier "webapps" d'Apache Tomcat.
Lancer le fichier startup qui se trouve dans le bin d'Apache Tomcat.

                                       5 - Lancer l'application 
                                       
Ouvrez votre navigateur et entrer l’url suivante : http://localhost:8080/escalade-webapp/
