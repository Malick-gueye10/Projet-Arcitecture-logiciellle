<html lang="en">

<head>
  <meta charset="UTF-8">
  <title>Page D'Accueil</title>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
  <link href='https://fonts.googleapis.com/css?family=Patua+One' rel='stylesheet' type='text/css'>
  <link href='https://fonts.googleapis.com/css?family=Roboto:400,300' rel='stylesheet' type='text/css'>
  <!-- CSS only -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
  <link href='./css/actualites.css' rel='stylesheet' type='text/css'>
  <!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
</head>

<body>
  <header>
    <h1>Actualités Polytechnitiennes</h1>
    <a href="login.php"><button type="button" class="btn btn-primary btn-sm">Connexion</button> </a>
    <a href="register.php"><button type="button" class="btn btn-secondary btn-sm">Inscription</button></a>
  </header>

  <?php
  require('./fonctions/fonctions.php');
  $categories = findAllByEntity('Categorie');
  ?>

  <nav>
    <ul>
      <a href="index.php">
        <li>Accueil</li>
      </a>
      <?php foreach ($categories as $cat) {  ?>
        <a href="<?php echo "index.php?idcategorie=" . $cat['id']; ?>">
          <li><?php echo $cat['libelle']; ?></li>
        </a>
      <?php } ?>
    </ul>
    <div class="handle">Menu</div>
  </nav>

  <div id="title">
    <h1>Les dernieres actualités </h1>
  </div>

  <section>
    <?php
    $articles = findAllByEntity('Article');
    ?>
    <?php
    if (isset($_GET['idcategorie'])) {
      $value = $_GET['idcategorie'];
      $mesArticles = getArticleByIdCategorie($value);
      if ($mesArticles == null) {
    ?>
        <h4 style="text-align:center ;"> Pas d'article pour cette catégorie </h4>
        <?php
      } else {
        foreach ($mesArticles as $art) {  ?>
          <div class="articles">
            <h2> <?php echo $art['titre']; ?> </h2>
            <div class="contenu">
              <?php echo $art['contenu']; ?> </h2>
            </div>
          </div>
          <br>

        <?php }
      }
    } else {
      foreach ($articles as $art) {  ?>
        <div class="articles">
          <h2> <?php echo $art['titre']; ?> </h2>
          <div class="contenu">
            <?php echo $art['contenu']; ?> </h2>
          </div>
        </div>

        <br>

    <?php }
    }
    ?>
  </section>
</body>
</html>