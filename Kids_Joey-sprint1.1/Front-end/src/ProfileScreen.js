import * as React from 'react';

import { StyleSheet,Image, View, SafeAreaView,Text,Button,TouchableOpacity } from 'react-native';

const ProfileScreen = ({ navigation }) => {
    return(
      <SafeAreaView  style={styles.container} >
        <TouchableOpacity onPress={() =>
      navigation.navigate('ActivityA')
      }>
      <View
        style={styles.box1} 
      >
        <Image source={require('./admin.png')} style={{width:90,height:90,position: 'absolute',bottom:3,left:2}} ></Image>
      <Text style={{color:'#C4C4C4',position:'absolute',right:8,top:15,fontSize:20}} > I'am an administrator</Text>

      </View></TouchableOpacity>
      <TouchableOpacity onPress={() =>
      navigation.navigate('ActivityA')
      }>
      <View
        style={styles.box}
      >
        <Image source={require('./teacher.jpg.png')} style={{width:70,height:75,position: 'absolute',
      left: 2}} ></Image>
      
      <Text style={{color:'#C4C4C4',position:'absolute',right:80,top:15,fontSize:20}} > I'am a teacher</Text>
      </View></TouchableOpacity>
      <TouchableOpacity onPress={() =>
      navigation.navigate('Act')
      }>
      <View
        style={styles.box}
      >
        <Image source={require('./parents.png')} style={{width:70,height:75,position: 'absolute',
      left: 2}} ></Image>
     
      <Text style={{color:'#C4C4C4',position:'absolute',right:89,top:15,fontSize:20}}> I'am a parent</Text>
      </View></TouchableOpacity>
      <TouchableOpacity onPress={() =>
      navigation.navigate('Act')
      }>
      <View
        style={styles.box}
      >
        <Image source={require('./doctor.png')} style={{width:70,height:75,position: 'absolute',
      left: 2}} ></Image>
      <Text style={{color:'#C4C4C4',position:'absolute',right:89,top:15,fontSize:20}} > I'am a doctor</Text>
      </View>
      </TouchableOpacity>

      
      </SafeAreaView>
        );
  };
  export default ProfileScreen;
  const styles = StyleSheet.create({
    container: {
      flex: 1,
      backgroundColor: '#fff',
      alignItems: 'center',
    },
    box1: {
      width: 50,
      height: 50,
      marginTop:70,
      paddingHorizontal:150,
      paddingVertical:40,
      backgroundColor: "white",
      borderColor:'#C4C4C4',
      borderWidth:2
    },
    box: {
      width: 50,
      height: 50,
      marginTop:50,
      paddingHorizontal:150,
      paddingVertical:40,
      backgroundColor: "white",
      borderColor:'#C4C4C4',
      borderWidth:2
    }
  });
