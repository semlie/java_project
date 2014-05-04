<?php

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

class wlApi {

    function __construct() {
        
    }
    function sendToApi($postURL, $data) {
        $ch = curl_init($postURL);
        curl_setopt($ch, CURLOPT_POST, true);
        curl_setopt($ch, CURLOPT_POSTFIELDS, $data);
        curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
        $returnValue = curl_exec($ch);
// process return value
        list ($cmd, $url) = explode("\n", $returnValue);
        return $cmd;
    }

    public function create($path, $param) {
        $postURL = 'http://ashira.co.il/index.php/register/' . $path;
// the Secret Key
        $secretKey = 'AERahp36FGTZlmr2';
// prepare the data
        $data = array();
        $data['cmd'] = 'CREATE';
        $data['transaction_id'] = $param['transaction_id'];
        $data['lastname'] = $param['lastname'];
        $data['firstname'] = $param['firstname'];
        $data['email'] = $param['email'];
        $data['level'] = $param['level'];
// generate the hash
        $delimiteddata = strtoupper(implode('|', $data));
        $hash = md5($data['cmd'] . '__' . $secretKey . '__' . $delimiteddata);
// include the hash to the data to be sent
        $data['hash'] = $hash;
// send data to post URL
        
        $ch = curl_init($postURL);
        curl_setopt($ch, CURLOPT_POST, true);
        curl_setopt($ch, CURLOPT_POSTFIELDS, $data);
        curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
        $returnValue = curl_exec($ch);
// process return value
        list ($cmd, $url) = explode("\n", $returnValue);
// check if the returned command is the same as what we passed
        if ($cmd == 'CREATE') {
            header('Location:' . $url);
            exit;
        } else {
            die('Error');
        }
    }

    public function activating($path, $param) {
        $postURL = 'http://ashira.co.il/index.php/register/' . $path;
// the Secret Key
        $secretKey = 'AERahp36FGTZlmr2';
        $data = array();
        $data['cmd'] = 'ACTIVATE';
        $data['transaction_id'] = $param['transaction_id'];
// generate the hash
        $delimiteddata = strtoupper(implode('|', $data));
        $hash = md5($data['cmd'] . '__' . $secretKey . '__' . $delimiteddata);
// include the hash to the data to be sent
        $data['hash'] = $hash;
// send data to post URL
// check if the returned command is the same as what we passed
        if (sendToApi($postURL, $data) == 'ACTIVATE') {
            die('Success');
        } else {
            die('Error');
        }
    }


    public function Deactivating($path, $param) {
                $postURL = 'http://ashira.co.il/index.php/register/' . $path;
// the Secret Key
        $secretKey = 'AERahp36FGTZlmr2';
        $data = array();
        $data['cmd'] = 'DEACTIVATE';
        $data['transaction_id'] = 'XYZ123456';
// generate the hash
        $delimiteddata = strtoupper(implode('|', $data));
        $hash = md5($data['cmd'] . '__' . $secretKey . '__' . $delimiteddata);
// include the hash to the data to be sent
        $data['hash'] = $hash;
// send data to post URL
// check if the returned command is the same as what we passed
        if (sendToApi($postURL, $data) == 'DEACTIVATE') {
            die('Success');
        } else {
            die('Error');
        }
    }

}
