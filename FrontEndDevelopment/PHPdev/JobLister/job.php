<?php include_once 'config/init.php'; ?>

<?php
$job = new Job;

if(isset($_POST['del_id'])){
    $del_id = $_POST['del_id'];
    if($job->delete($del_id)){
        redirect('index.php', 'The posting has been deleted.', 'success');
    } else {
        redirect('index.php', 'Strange, I cannot delete this posting.', 'error');
    }
}

$template= new Template('templates/job-single.php');

$job_id = isset($_GET['id']) ? $_GET['id'] : null;

// Get Categories from Database
$template->job = $job->getJob($job_id);

echo $template;