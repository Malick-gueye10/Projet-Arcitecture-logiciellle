<?php

// je vais creer une fonction pour  établir une connexion avec la base de données
function getConnexion()
{

    try {
        $bdd = new PDO("mysql:host=localhost;dbname=mglsi_news", "root", "");
        $bdd->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
        return $bdd;
    } catch (PDOException $ex) {
        print "Erreur de connexion à la base de donnée : " . $ex->getMessage();
        return null;
        die();
    }
}
// fonction qui permet d'executer des requetes de type SELECT
function executeSelect($sql)
{
    $bdd = getConnexion();
    $sth = $bdd->prepare($sql);
    $sth->execute();
    $result = $sth->fetchAll();
    return  $result;
}

// fonction pour faire une requete sur une table donnée en entrée
function findAllByEntity($entity) 
{
    $sql = "SELECT *  FROM $entity";
    $data = executeSelect($sql);
    if (count($data) == 0) {
        return null;
    }
    return  $data;

}

// fonction pour recuperer un ou des articles rattaché(s) à une catégorie 
function getArticleByIdCategorie($idCategorie)
{
    $sql = "SELECT *  FROM Article a where a.categorie='$idCategorie'";
    $data = executeSelect($sql);
    if (count($data) == 0) {
        return null;
    }
    return  $data;
}
 

