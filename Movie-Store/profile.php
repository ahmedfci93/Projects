<?php
require_once 'core/init.php';

$username= input::get('username');

	$user= new user($username);
	if(!$user->exists()){
		Redirect::to(404);
		 } else {
			$data = $user->data();
		
		?>
		<h3><?php echo escape($data->username); ?></h3>
		<p>Full Name: <?php echo escape($data->name); ?></p>
		<?php
	}
	?>
	<a href="index.php">Home</a>