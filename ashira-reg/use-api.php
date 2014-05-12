<?php

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


// post paremter
$postdata = file_get_contents("php://input");
//convert to arrey
$request = json_decode($postdata);
$request = (array) $request;
//address: "hert"



$pname = isset($request['pname']) ? $request['pname'] : '';
$username = isset($request['username']) ? $request['username'] : '';
$pass = isset($request['pass']) ? $request['pass'] : '';
$address = isset($request['address']) ? $request['address'] : '';
$city = isset($request['city']) ? $request['city'] : '';
$country = isset($request['country']) ? $request['country'] : '';
$teacher = isset($request['teacher']) ? $request['teacher'] : '';
$maslul = isset($request['maslul']) ? $request['maslul'] : '0';
$maslulSum = isset($request['maslulSum']) ? $request['maslulSum'] : '0';
$cardOwner = isset($request['card_owner']) ? $request['card_owner'] : '';
$cardNumber = isset($request['card_number']) ? $request['card_number'] : '';
$cardExpireMonth = isset($request['card_expire_month']) ? $request['card_expire_month'] : '';
$cardExpireYear = isset($request['card_expire_year']) ? $request['card_expire_year'] : '';
$ownerPhone = isset($request['owner_phone']) ? $request['owner_phone'] : '';
$ownerEmail = isset($request['mail']) ? $request['mail'] : '';
//================
$ownerZehut = isset($request['owner_zehut']) ? $request['owner_zehut'] : '';
$cardType = isset($request['card_type']) ? $request['card_type'] : '';
$cardCvv = isset($request['card_cvv']) ? $request['card_cvv'] : '';
$paymentsCount = isset($request['payments_num']) ? $request['payments_num'] : '0';
$paymentsCount2 = isset($request['payments_num2']) ? $request['payments_num2'] : '0';
$firstPaymentSum = 0;
$otherPaymentsSum = 0;


//set time
date_default_timezone_set('Asia,Jerusalem');
$date = date('Y/m/d');

$date = date('Y-m-d', strtotime("+3 months", strtotime($date)));

try {
    // var_dump($request);
    //header('Content-Type: application/json');
    echo json_encode($pname);
//    print_r($cardExpireMonth);
} catch (Exception $exc) {
//    echo $exc->getTraceAsString();
}

//$user_login 
//$user_email 
//$user_pass 
//$company 
//$address1 
//$address2 
//$city 
//$state 
//$zip 
//$country 
//$wpm_login_limit 
//$wpm_registration_ip 
//$custom_{field} 
//variable 
//$Sequential 
//$Levels
//$RemoveLevels


include('wlmapiclass.php');

////check if it alredy member or user
//if it member just updete the expe_date
//if it only user ,update all the data and add the group
//// if its new user create new account and add user to group

$levels = array();
//add the levels
switch ($maslul) {
    case '40sub':
        $levels[] = '';
        $levels[] = '';

        break;
    case '30sub':
        $levels[] = '';

        break;

    default:
        break;
}
//add time to subscribe
switch ($maslulSum) {
    case 3:
$date = date('Y-m-d', strtotime("+3 months", strtotime($date)));

        break;
    case 6:
$date = date('Y-m-d', strtotime("+6 months", strtotime($date)));

        break;
    case 12:
$date = date('Y-m-d', strtotime("+12 months", strtotime($date)));

        break;

    default:
        break;
}

//address

$api_adres = "http://ashira.co.il";

function createNewMember($name, $email,$user_pass,$address,$city, $country ,$expDate ,$levels) {
    //get api object
    $api = new wlmapiclass($api_adres, $api_m);
    $api->return_format = 'php'; // <- value can also be xml or json
//add the data to send 
    $data = array();
    $data['user_login'] = $name;
    $data['user_email'] = $email;
    $data['user_pass'] = $user_pass;
    $data['address1'] = $address;
    $data['city'] = $city;
    $data['country'] = $country;
    $data['Levels'] = $levels;
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
    $api = new wlmapiclass($api_adres, $api_m);
    $api->return_format = 'php'; // <- value can also be xml or json
//add the data to send 
    $data = array();
    $data['user_login'] = $name;
    $data['user_email'] = $email;
    //expretion date 
    $data['custom_exp_date'] = $expDate;
    //send it 
    $response = $api->put('/members', $data);
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

function secssesResponse($response) {
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
    $api = new wlmapiclass($api_adres, $api_m);
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

/*
 * chack specific user name if is member
 */

function getSpecificMember($name, $email) {
    try {
        $mam = getAllMembers();
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

//echo getSpecificMember("1_admin", "israellieb@gmail.com");
