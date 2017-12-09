<?php 
	require_once 'core/init.php';
	$user = new user();
	if(!$user->isLoggedIn()){
			Redirect::to('login.php');
	}

	$data = $user->data();
	$id=$data->id;
?>
<html>
	<body>
	<ul>
		<li><a href="index.php">Profile</a></li>
		<li><a href="logout.php">logout</a></li>
	</ul>
		
		<?php
			$offer=DB::getInstance()->get('added_movies',array('seller_id','=', $id));
			echo  '<h2>your Offers Info are : </h2>';
				
			if($offer->count()){
				foreach($offer->results() as $row){
				$movie_id=$row->id;
				$movie_name=$row->name;
				$production_year=$row->yearofproduction;
				echo '<ul><li><a href="update_movie.php/?id=',$movie_id,'">',$movie_name,'(',$production_year,')</a></br></li></ul>';
				
				}
				session::put('seller_id', $id);

		     	
			}
		?>
	</body>
</html>