<?php 
require_once 'core/init.php';
$user = new user();
if(!$user->isLoggedIn()){
		Redirect::to('login.php');
}

$data = $user->data();
$id=$data->id;
if(input::exists()){
	if(token::check(input::get('token'))){

	$Validate=new validate();
	$validation=$Validate->check($_POST, array(
		'name' => array(
			'required'=>true,
			'min'=> 2,
			'max' => 100,
		),
		'quant' => array(
			'required'=>true,
			'min' => 1
		),
		'cat_movie' => array(
			'required' => true
		),
		'type' => array(
			'required'=>true
			),
		'price' => array(
			'required'=>true
			),
		'date' => array(
			'required'=>true
			)

		));

	if($validation->passed()){
		$conn=DB::getInstance();
		try{
			$conn->insert('added_movies',array(
				'name' => input::get('name'),
				'quantity' => input::get('quant'),
				'category'=>input::get('cat_movie'),
                'type' => input::get('type'),
				'seller_id' => $id,
				'price' => input::get('price'),
				'yearofproduction' => input::get('date'),
				'status'=>'new'
			));
			Redirect::to('approved.php');

		} catch(Exception $e){
			die($e->getMessage());
		}
	} else {
		foreach($validation->errors() as $error){
			echo $error, '<br>';

		}

	}

}
}
		
?>
<html>
	<body>
	<ul>
		<li><a href="index.php">Profile</a></li>
		<li><a href="logout.php">logout</a></li>
	</ul>
		<form action ="" method="post">
  		Movie Name:<br>
  		<input type="text" name="name"><br>
		  Quantity:<br>
		  <input type="text" name="quant">
		  <br><br>Category: 
		  <select name="cat_movie">
		  <option value="comedy">Comedy</option>
		  <option value="horror">Horror</option>
		  <option value="tragedy">Tragedy</option>
		  <option value="action">Action</option>
		  <option value="drama">Drama</option>

			</select>
		  <br>Movie Type:&nbsp;
		  <input type="radio" name="type" value="dvd"> DVD &nbsp; <input type="radio" name="type" value="video"> Video<br>
		  Price:<br>
		  <input type="text" name="price">
		  <br>Year Of Production:<br>
		  <input type="date" data-date-inline-picker="true"  name="date"/><br>
		  <input type="hidden" name="token" value="<?php echo token::generate(); ?>">
		  <input type="submit" name="submit" id="input" value="add">
		</form>
	</body>
</html>