<?php

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

include('wlmapiclass.php');

////check if it alredy member or user
//if it member just updete the expe_date
//if it only user ,update all the data and add the group
//// if its new user create new account and add user to group

function createNewMember($name, $email, $expDate, $levels) {
    //get api object
    $api = new wlmapiclass('http://ashira.co.il/', '73a8cba5f3ad8b5425ef001806613434');
    $api->return_format = 'php'; // <- value can also be xml or json
//add the data to send 
    $data = array();
    $data['user_login'] = $name;
    $data['user_email'] = $email;
    //expretion date 
    $data['custom_exp_date'] = $expDate;
    //send it 
    $response = $api->post('/members', $data);
    $response = unserialize($response);
    echo sizeof($response);
    var_dump($response);
    try {
        if (is_a($response, 'array')) {
            echo 'isset';
            list($seccses, $all) = $response;
        } else {
            $seccses = $response['success'];
        }
    } catch (Exception $exc) {
        echo 'exeption';
        errLog($exc->getTraceAsString());
    }

    if ($seccses) {
        echo 'secsssssss';
        var_dump($response);
        print_r($response);
    } else {
        switch ($response['ERROR_CODE']) {
            case 'E-mail already exists':
                echo 'E-mail';
                break;
            case 'Username already exists':
                echo 'UserName ';
                break;
            default :
                errLog($response['ERROR_CODE']);
                break;
        }
    }
}

function updateMemberDate($name, $email, $expDate, $levels) {
    //get api object
    $api = new wlmapiclass('http://ashira.co.il/', '73a8cba5f3ad8b5425ef001806613434');
    $api->return_format = 'php'; // <- value can also be xml or json
//add the data to send 
    $data = array();
    $data['user_login'] = $name;
    $data['user_email'] = $email;
    //expretion date 
    $data['custom_exp_date'] = $expDate;
    //send it 
    $response = $api->post('/members', $data);
    $response = unserialize($response);
    echo sizeof($response);
    var_dump($response);

    $seccses = secssesResponce($response); //parse the response

    if ($seccses) {
        echo 'secsssssss';
        var_dump($response);
        print_r($response);
    } else {
        switch ($response['ERROR_CODE']) {
            case 'E-mail already exists':
                echo 'E-mail';
                break;
            case 'Username already exists':
                echo 'UserName ';
                break;
            default :
                errLog($response['ERROR_CODE']);
                break;
        }
    }
}

function errLog($text = '') {
    if ($text == '') {
        echo 'Errr';
    } else {
        echo $text;
    }
}

function secssesResponce($response) {
    try {
        if (is_a($response, 'array')) {
            echo 'isset';
            list($seccses, $all) = $response;
            return $seccses;
        } else {
            $seccses = $response['success'];
            return $seccses;
        }
    } catch (Exception $exc) {
        echo 'exeption';
        errLog($exc->getTraceAsString());
        return false;
    }
}

//$response = $api->get('/members/1');
//$response = $api->post('/levels',$data);
//createNewMember("test4", "4@test.co.il", "12/7/2012", "1313484976");
//$response = unserialize($response);
function getAllMembers() {
    $api = new wlmapiclass('http://ashira.co.il/', '73a8cba5f3ad8b5425ef001806613434');
    $api->return_format = 'php'; // <- value can also be xml or json

    $data = array();
//    $data['user_login'] = $name;
//    $data['user_email'] = $email;
//    // $data['custom_exp_date']=$expDate;
    $response = $api->get('/members');
    $response = unserialize($response);

    // $response = $api->post('/levels',$data)

    if (secssesResponce($response)) {

        $mem = $response['members']['member']; //hold array of all members 

        return($mem);
    }
}

function getSpecificMember($name, $email) {
    try {
        $mam=getAllMembers();
        var_dump($mam);
        $user = searchUsers($mam, $email);
        print_r($user);
        if ($user) {
            
        }
    } catch (Exception $exc) {
        echo $exc->getTraceAsString();
    }
}

function searchUsers($param, $searchCreteria) {
    foreach ($param as $key => $valeu) {
        

        if ($valeu['user_email'] == $searchCreteria) {
            return $valeu;
        } else {
            return false;
        }
    }
}

echo getSpecificMember("1_admin","israellieb@gmail.com");
