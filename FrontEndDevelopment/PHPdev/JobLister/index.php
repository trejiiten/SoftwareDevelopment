<?php include_once 'config/init.php'; ?>

<?php
$job = new Job;

$template = new Template('templates/frontpage.php');

$category = isset($_GET['category']) ? $_GET['category'] : null;

if($category){
    $template->jobs = $job->getByCategory($category);
    $template->title = $job->getCategory($category)->name.' Jobs Available';
} else {
    $template->title = 'Latest Jobs';

    // Get All Jobs
    $template->jobs = $job->getAllJobs();
}

// Get Categories from Database
$template->categories = $job->getCategories();

echo $template;