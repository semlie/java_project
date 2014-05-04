<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <meta charset="UTF-8">
        <title></title>
    </head>
    <body>
        <?php
       
// the post URL
include('use-api.php');
//include('wlapi.php');
//$wlApi =new wlApi();
//$data = array();
// $data['transaction_id'] = 'frodo@ww1www.com';
//        $data['lastname'] = 'Bagg1ins';
//        $data['firstname'] = 'Frodo';
//        $data['email'] = 'frodo@ww1www.com';
//        $data['level'] = '1313484976';
////$wlApi->create('Edhpsy',$data);
//$wlApi->activating('Edhpsy',$data);

//        $postURL = 'http://ashira.co.il/index.php/register/Edhpsy';
//// the Secret Key
//        $secretKey = 'AERahp36FGTZlmr2';
//// prepare the data
//        $data = array();
//        $data['cmd'] = 'CREATE';
//        $data['transaction_id'] = 'XYZ123456';
//        $data['lastname'] = 'Baggins';
//        $data['firstname'] = 'Frodo';
//        $data['email'] = 'frodo@wwwww.com';
//        $data['level'] = '1313484976';
//// generate the hash
//        $delimiteddata = strtoupper(implode('|', $data));
//        echo $delimiteddata;
//        $hash = md5($data['cmd'] . '__' . $secretKey . '__' . $delimiteddata);
//// include the hash to the data to be sent
//        $data['hash'] = $hash;
//        echo $hash;
//// send data to post URL
//        $ch = curl_init($postURL);
//        curl_setopt($ch, CURLOPT_POST, true);
//        curl_setopt($ch, CURLOPT_POSTFIELDS, $data);
//        curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
//        $returnValue = curl_exec($ch);
//// process return value
//        list ($cmd, $url) = explode("\n", $returnValue);
//// check if the returned command is the same as what we passed
//        if ($cmd == 'CREATE') {
//            header('Location:' . $url);
//            exit;
//        } else {
//            die('Error');
//        }
        ?>

       
    </body>
</html>
