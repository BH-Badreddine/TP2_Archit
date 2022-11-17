# TP2_Archit
<h1>Question 4</h1>
On a inversé la dépendance entre ("EtudiantService","UniversiteRepository") et entre("EtudiantService","EtudiantRepository")pour permettre aux classes "UniversiteRepository"et "EtudiantRepository" qui sont instables(subissent beaucoup de changements) de dépendre d'une classe plus stable:"EtudiantService" et non pas l'inverse. 
