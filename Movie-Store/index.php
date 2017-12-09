<?php
    require_once'core/init.php';
    $user=new user();

    if($user->isloggedIn()){ 
    $data = $user->data();
    $user_id=$data->id;
    $user_type=$data->user_type;

?>

    <?php $movies = $user->view_movie($user_id,$user_type); ?>
         
    <?php }else { ?>
    <a href="login.php">login</a></li> OR .... <a href="register.php">register</a>
    <h3>you could check our user manual<a href="user_help.php"> here</a>
    <?php }?>
</body>
</html>