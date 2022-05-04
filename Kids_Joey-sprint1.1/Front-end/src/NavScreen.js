import * as React from 'react';
import { useNavigation } from '@react-navigation/native';
import { StyleSheet,Image, View, SafeAreaView,ScrollView,TouchableOpacity} from 'react-native';
import { Button } from 'react-native-paper';
const NavScreen= () => {
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
      style={{ width: 30, height: 30,marginRight:7,marginTop:50 }}
    />
  )}></Button>
  <Button onPress={() =>
      navigation.navigate('Meals')}
  icon={() => (
    <Image
      source={require('./restaurant.png')}
      style={{ width: 30, height: 30,marginRight:7,marginTop:50 }}
    />
    
  )}></Button>
  
  <Button onPress={() =>
      navigation.navigate('Comment')}
  icon={() => (
    <Image
      source={require('./comment.png')}
      style={{ width: 30, height: 30,marginRight:7,marginTop:50 }}
    />
    
  )}></Button>

   <Button onPress={() =>
      navigation.navigate('MediaScreen')}
  icon={() => (
    <Image
      source={require('./camera.png')}
      style={{ width: 30, height: 30,marginRight:7,marginTop:50 }}
    />
  )}></Button>
      <Button onPress={() =>
      navigation.navigate('Act')}
  icon={() => (
    <Image
      source={require('./calculator.png')}
      style={{ width: 30, height: 30,marginRight:7,marginTop:50 }}
    />
  )}></Button>
  <Button onPress={() =>
      navigation.navigate('EnfantScreen')}
  icon={() => (
    <Image
      source={require('./kid.png')}
      style={{ width: 30, height: 30,marginRight:7,marginTop:50 }}
    />
  )}></Button>
      
      <View style={{height:1 , backgroundColor: '#C4C4C4',marginTop:50}} />

      <Button onPress={() =>
      navigation.navigate('SettingScreen')}
  icon={() => (
    <Image
      source={require('./settings.png')}
      style={{ width: 30, height: 30,marginRight:7,marginTop:50 }}
    />
  )}></Button>

      </View>
      
      </SafeAreaView>
  
  );
}

export default NavScreen;
const styles = StyleSheet.create({
  container: {
   
    backgroundColor: '#fff',
  },
  box1: {
    width: 40,
    height: 700,
    backgroundColor: "white",
    borderColor:'#C4C4C4',
    borderWidth:1,
    
  }
});