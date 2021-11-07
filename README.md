# ElasticSearch-CVtheque

Verifier que vous avez bien Maven, elasticsearch et kibana d'installer

1 cloner le repository,
2 se placer dans le dossier JavaES
3 mvn install
4 executer elasticsearch/elasticsearch.bat  
5 executer kibana/kibana.bat
6 aller sur Postman, afin de get tout les CVs sur http://127.0.0.1:8080/api/cvs
7 aller sur Postman, afin de faire les posts sur http://127.0.0.1:8080/api/cvs aller dans Body, form-data. dans le premier champs la KEY est "file" de type file et choisissez votre fichier envoyer et c est bon 
8 aller sur Postman, afin de get les CVs en faisant une recherche par mot (par exemple java) sur http://127.0.0.1:8080/api/cvs aller dans Body, form-data. dans le premier champs la KEY est "keyword" de type text et choisissez votre mot (exemple java) et c est bon 