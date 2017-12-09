<?php 
require_once 'core/init.php';
$user = new user();
if($user->isLoggedIn()){ Redirect::to('index.php'); }
if(input::exists()){
	if(token::check(input::get('token'))){

	$Validate=new validate();
	$validation=$Validate->check($_POST, array(
		'username' => array(
			'required'=>true,
			'min'=> 2,
			'max' => 20,
			'unique' => 'users'
		),
		'password' => array(
			'required'=>true,
			'min' => 6
		),
		'password_again' => array(
			'required' => true,
			'matches' => 'password'
		),
		'Address' => array(
			'required'=>true,
			'min'=>5,
			'max'=>50
			)
		));

	if($validation->passed()){
		$user= new user();

		$salt=Hash::salt(32);
		try{
			$user->create(array(
				'username' => input::get('username'),
				'password' => Hash::make(input::get('password'), $salt),
				'name'=>input::get('name'),
				'salt' => $salt,
                'email' => input::get('email'),
				'Address' => input::get('Address'),
				'Mobile' => input::get('Mobile'),
				'joined' => date('Y-m-d H:i:s'),
				'user_type'=>'2'
			));
			$login= $user->login(input::get('username'), input::get('password'), $remember);
			Redirect::to('index.php');

		} catch(Exception $e){
			die($e->getMessage());
		}
	} else {
		foreach($validation->errors() as $error){
			echo $error, '<br>';

		}

	}

}}
?>




<div id="contact">
      <form action ="" method="post">
        <div class="field">
	       <label for="username">* Username</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	       <input type="text" name="username" id="input" id="username" value="<?php echo escape(input::get('username')); ?>" autocomplete="off" required>	
        </div>
        <div class="field">
	       <label for="username">* name</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	       <input type="text" name="name" id="input" id="name" value="<?php echo escape(input::get('name')); ?>" autocomplete="off" required>	
        </div>
        <div class="field">
          <label for="password">* Enter your password</label>&nbsp;&nbsp;&nbsp;&nbsp;
          <input type ="password" name="password" id="input"  id="password" required>
        </div>
        <div class="field">
          <label for="password_again">* Confirm Password</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          <input type ="password" name="password_again"  id="input" id="password_again" required>
        </div>
        <div class="field">
           <label for="name">* Address</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          <input type ="text" name="Address" id="input" value="<?php echo escape(input::get('Address')); ?>" id="Address" required>
        </div>
        <div class="field">
           <label for="name">* Mobile</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          <input type ="text" name="Mobile" id="input" value="<?php echo escape(input::get('Mobile')); ?>" id="Mobile" required>
        </div>
        <div class="field">
           <label for="email">* E-mail</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          <input type ="text" name="email" id="input" value="<?php echo escape(input::get('email')); ?>" id="email" required>
        </div>
          <input type="hidden" name="token" value="<?php echo token::generate(); ?>">
          <input type="submit" id="input" value="Register">
      </form> 
</div>




