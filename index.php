<?php
    //open connection to mysql db
    $connection = mysqli_connect("127.0.0.1","root","root","nft") or die("Error " . mysqli_error($connection));

    //fetch table rows from mysql db
    $sql = "select * from floor_price";
    $result = mysqli_query($connection, $sql) or die("Error in Selecting " . mysqli_error($connection));

    //create an array
    $emparray = array();
    while($row =mysqli_fetch_assoc($result))
    {
        $emparray[] = $row;
    }
header('Content-Type: application/json');

    echo json_encode($emparray, JSON_PRETTY_PRINT);

    //close the db connection
    mysqli_close($connection);
?>