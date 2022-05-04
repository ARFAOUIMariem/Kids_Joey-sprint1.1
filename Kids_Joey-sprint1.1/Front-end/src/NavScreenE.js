import * as React from 'react';
import { useNavigation } from '@react-navigation/native';
import { StyleSheet,Image, View, SafeAreaView,ScrollView,TouchableOpacity} from 'react-native';
import { Button } from 'react-native-paper';
const NavScreenE= () => {
  const navigation = useNavigation(); 
  return(
    <SafeAreaView  style={styles.container} >
      
    <View
      style={styles.box1}>
         <Button onPress={() =>
      navigation.navigate('Planning')}
  icon={() => (
    <Image
      source={require('./time.png')}
      style={{ width: 50, height: 50,marginLeft:10,marginTop:20 }}
    />
  )}></Button>
  <Button onPress={() =>
      navigation.navigate('Meals')}
  icon={() => (
    <Image
      source={require('./restaurant.png')}
      style={{ width: 50, height: 50,marginLeft:10,marginTop:50 }}
    />
  )}></Button>
   <Button onPress={() =>
      navigation.navigate('MediaScreen')}
  icon={() => (
    <Image
      source={require('./camera.png')}
      style={{ width: 50, height: 50,marginLeft:10,marginTop:50 }}
    />
  )}></Button>
      <Button onPress={() =>
      navigation.navigate('ActivityA')}
  icon={() => (
    <Image
      source={require('./calculator.png')}
      style={{ width: 50, height: 50,marginLeft:10,marginTop:50 }}
    />
  )}></Button>
 

<Button onPress={() =>
      navigation.navigate('EnfantScreen')}
  icon={() => (
    <Image
      source={require('./heart-beat.png')}
      style={{ width: 50, height: 50,marginLeft:10,marginTop:50 }}
    />
  )}></Button>
       
  
      <View style={{height:1 , backgroundColor: '#C4C4C4',marginTop:50}} />

      <Button onPress={() =>
      navigation.navigate('SettingScreen')}
  icon={() => (
    <Image
      source={require('./settings.png')}
      style={{ width: 50, height: 50,marginLeft:10,marginTop:50 }}
    />
  )}></Button>

      </View>
      
      </SafeAreaView>
  
  );
}

export default NavScreenE;
const styles = StyleSheet.create({
  container: {
   
    backgroundColor: '#fff',
  },
  box1: {
    width: 70,
    height: 1200,
    backgroundColor: "white",
    borderColor:'#C4C4C4',
    borderWidth:1,
    
  }
});