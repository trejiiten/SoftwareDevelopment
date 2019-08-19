<?php include 'inc/header.php'; ?>
    <h2 class="page-header"><?php echo $job->job_title; ?> (<?php echo $job->location; ?>)</h2>
    <small>Posted By <?php echo $job->contact_user; ?> on <?php echo $job->post_date; ?></small>
    <hr>
    <p class="lead"><?php echo $job->description; ?></p>
    <ul class="list-group">
        <li class="list-group-item"><strong>Company:</strong> <?php echo $job->company; ?></li>
        <li class="list-group-item"><strong>Salary:</strong> <?php echo $job->salary; ?></li>
        <li class="list-group-item"><strong>Contact Name &amp; Email:</strong> <i><?php echo $job->contact_user; ?></i>, <?php echo $job->contact_email; ?></li>
    </ul>
    <br><br>
    <a href="index.php">Go Back</a>
    <br><br>
    <!-- Edit Form -->
    <div class="well">
        <a href="edit.php?id=<?php echo $job->id; ?>" class="btn btn-default btn-lg">Edit</a>
        <!-- Delete Entry -->
        <form style="display: inline;" method="post" action="job.php">
            <input type="hidden" name="del_id" value="<?php echo $job->id; ?>">
            <input type="submit" class="btn btn-danger btn-lg" value="Delete">
        </form>
    </div>

<?php include 'inc/footer.php'; ?>