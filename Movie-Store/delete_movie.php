<?php 
require_once 'core/init.php';
$user = new user();
if(!$user->isLoggedIn()){
        Redirect::to('login.php');
}

$data = $user->data();
$id=$data->id;
$movie=DB::getInstance()->get('added_movies',array('seller_id','=',$id));
        ?>
<html>
        <ul>
        <li><a href="index.php">Profile</a></li>
        <li><a href="logout.php">logout</a></li>
    </ul>
    <?php
    if($movie->count()){?>
        <body>
 <table class="table" border="1" style="width:100%">
     <thead>
              <tr>
                <th>Id</th>
                <th>Movie</th>
                <th>Quantity</th>
                <th>Category</th>
                <th>Type</th>
                <th>Price</th>
                <th>Year Of Production</th>
                <th>Delete</th>
              </tr>
            </thead>
            <tbody>
      <?php foreach ($movie->results() as $m) { ?>
             <tr>
             <td><?php echo $m->id;?></td>
             <td><?php echo $m->name;?></td>
             <td><?php echo $m->quantity;?></td>
             <td><?php echo $m->category;?></td>
             <td><?php echo $m->type;?></td>
             <td><?php echo $m->price;?></td>
             <td><?php echo $m->yearofproduction;?></td>
             <form action ="delete.php" method="post">
            <input type="hidden" name="id" value="<?php echo $m->id;?>">
            <td> <input type="submit" name="Delete" value="delete"></td>
             </form>
            <?php }
        }
        else{
            echo "there are not any movie... go to   ";?>
            <a href="add_movie.php">add movie</a><?php
            
        }
             ?>
             
            </tr>
      <?php echo "<br>";?>
</tbody>
</table>