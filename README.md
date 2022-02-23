# MySQLdumpHelper
Script pour modifier les fichiers sql du dossier dump à importer pour éviter les erreurs.

Erreurs : 
- Access denied; you need (at least one of) the SUPER privilege(s) for this operation
- Variable 'sql_log_bin' can't be set to the value of 'NULL'

1. maven compile 
2. java -jar /Users/me/IdeaProjects/MySQLdumpHelper/target/dump-helper.jar <param : dossier à du dump, dossier courant par défaut>
