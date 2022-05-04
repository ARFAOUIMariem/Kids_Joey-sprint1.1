import { StatusBar } from 'expo-status-bar';
import { StyleSheet,Image, View, SafeAreaView } from 'react-native';
import {Button} from 'react-native-paper';
const HomeScreen = ({ navigation }) => {
 
    return (
      <SafeAreaView style={styles.container}>
      <View style={styles.title}>
      <Image source={require('./Kangorou.jpg.png')} style={{ width: 290, height: 120}} />
        
        <StatusBar style="auto" />
      </View>
      <View>
      <Button style={styles.loginBtn} onPress={() =>
      navigation.navigate('Auth')
      }>Get Started</Button>
  
      
      </View>
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
    title: {
      alignItems: 'center',
      justifyContent: 'center', 
      
    },
    loginBtn:
 {
   width:"80%",
   backgroundColor:"#FFC0F0",
   marginTop:80
 }
  });
  export default HomeScreen;
