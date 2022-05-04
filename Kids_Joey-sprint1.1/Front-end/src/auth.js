import { StatusBar } from "expo-status-bar";

import React, { useState } from "react";
import {
  StyleSheet,
  Text,
  View,
  Image,
  TextInput,
  TouchableOpacity,
  SafeAreaView
} from "react-native";
import { Avatar,Button, Card, Title, Paragraph,IconButton } from 'react-native-paper';


const AuthScreen = ({ navigation }) => {
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
  return (
    <SafeAreaView style={styles.container} >
        <View style={styles.image}>
        <Image source={require('./Kangorou.jpg.png')} style={{ width: 290, height: 120}} />
      </View>
    <View style={styles.inputView}>
  <TextInput
    style={styles.TextInput}
    placeholder="Email."
    placeholderTextColor="#5678FF"
    onChangeText={(email) => setEmail(email)}
  />
</View>
 
<View style={styles.inputView}>
  <TextInput
    style={styles.TextInput}
    placeholder="Password."
    placeholderTextColor="#5678FF"
    secureTextEntry={true}
    onChangeText={(password) => setPassword(password)}
  />
</View>
<TouchableOpacity>
  <Text style={styles.forgot_button}>Forgot Password?</Text>
</TouchableOpacity>
<TouchableOpacity style={styles.loginBtn}>
  <Button onPress={() =>
      navigation.navigate('Profile')
      }>LOGIN</Button>
</TouchableOpacity>
</SafeAreaView>
  );
};
const styles = StyleSheet.create({
    container: {
      flex: 1,
      backgroundColor: '#fff',
      alignItems: 'center',
      justifyContent: 'center',
     },
     image :{
        marginBottom: 40
     
      },
      inputView: {
        backgroundColor: "#E1E1E1",
        borderRadius: 30,
        width: "70%",
        height: 45,
        marginBottom: 20,
        alignItems: "center",
      },
      
      TextInput: {
        height: 50,
        flex: 1,
        padding: 10,
        marginLeft: 20,
      },
      forgot_button: {
        height: 30,
        marginBottom: 30,
      },
      loginBtn:
 {
   width:"80%",
   borderRadius:25,
   height:50,
   alignItems:"center",
   justifyContent:"center",
   marginTop:40,
   backgroundColor:"#FFC0F0",
 }

  });
export default AuthScreen;
