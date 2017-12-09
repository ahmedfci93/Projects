<?php
require_once 'core/init.php';
$user = new user();
if($user->isLoggedIn()){ Redirect::to('index.php'); }

if(input::exists()){
 if(token::check(input::get('token'))){

 	$validate=new Validate();
 	$validation=$validate->check($_POST, array(
 		'Name' => array('required' => true),
 		'password' => array('required' => true)


 	));
 	if($validation->passed()){
 		$user = new user();

 		$remember = (input::get('remember') === 'on') ? true : false;
 		$login= $user->login(input::get('Name'), input::get('password'), $remember);
 		if($login){
 			redirect::to('profile.php');
 		} else {
 			echo '<p>Sorry, logging in failed.</p>';
 			?> you can register if you have not account<a href="register.php"> REGISTER</a><?php
 		}
 	} else{
 		foreach($validation->errors() as $error){
 			echo $error, '<br>';
 		}

 	}

 }
}

?>

<html>
<head>
</head>
<body>


	<div class="cap offset12 span4">
    	<form class="reg_form" action="" method="post">
    		
    		<label for ="Name"></label>
			<input type="text" class="inpue-larg" name="Name" id="Name" autocomplete="off" placeholder="Name...">

    		
    		<label for ="password" class="inpue-medium"></label>
			<input type="password" class="inpue-medium" name="password" id="password" autocomplete="off" placeholder="Password...">
			<br/>

			<label for ="remember" class="checkbox">Remember me
			<input type="checkbox" name="remember" id="remember">
			</label>

			<br/>

			<input type="hidden" name="token" value="<?php echo token::generate(); ?>">
            <button class="btn btn-info" type="submit" value="log in">Log In</button>
		</form>
	</div>
	<!--carousel end-->
</body>
</html>