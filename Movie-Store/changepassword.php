<?php
	require_once 'core/init.php';

	$user= new user();

	if(!$user->isLoggedIn()){
		Redirect::to('index.php');
	}

	if(input::exists()){
		if(token::check(input::get('token'))){
			$validate=new validate();
			$validation= $validate->check($_POST, array(
				'password_current' => array(
					'required' => true,
					'min' => 6
					),
				'password_new' => array(
					'required' => true,
					'min' => 6
					),
				'password_new_again' => array(
					'required' => true,
					'min' => 6,
					'matches' => 'password_new'
					)


			));

			if($validation->passed()){
				if(Hash::make(input::get('password_current'), $user->data()->salt) !== $user->data()->password){
					echo 'Your current password is wrong';

				}else {
					$salt= Hash::salt(32);
					$user->update(array(
						'password' => Hash::make(input::get('password_new'), $salt),
						'salt'=> $salt
					));

					session::flash('home', 'Your password has been updated.');
					Redirect::to('index.php');
				}


			} else {
				foreach($validation->errors() as $error){
					echo $error, '<br>';
				}
			}


		}
	}
?>

	<ul>
		<li><a href="index.php">Profile</a></li>
		<li><a href="logout.php">logout</a></li>
	</ul>
<form action="" method="post">
<div class="field">
	<label for="password_current">Current password</label>
	<input type="password" name="password_current" id="password_current">
</div>

<div class="field">
	<label for="password_new">New password</label>
	<input type="password" name="password_new" id="password_new">
</div>

<div class="field">
	<label for="password_new_again">New password again</label>
	<input type="password" name="password_new_again" id="password_new_again">
</div>

<input type="submit" value="Change">
<input type="hidden" name="token" value="<?php echo token::generate(); ?>">
</form>