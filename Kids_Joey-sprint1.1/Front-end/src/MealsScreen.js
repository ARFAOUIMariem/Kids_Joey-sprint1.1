import React, {useState, useEffect}from 'react'
import { Alert, Text } from 'react-native';
import { StyleSheet,Image, View,SafeAreaView,ScrollView} from 'react-native';
import NavScreen from './NavScreen';
import { Avatar,Button, Card, Title, Paragraph } from 'react-native-paper';

const ActScreen= () => {
  const LeftContent = props => <Avatar.Icon {...props} icon="folder" />

    const [currentDate, setCurrentDate] = useState('');
        useEffect(() => {
          var date = new Date().getDate(); //Current Date
          var month = new Date().getMonth() + 1; //Current Month
          var year = new Date().getFullYear(); //Current Year
          var hours = new Date().getHours(); //Current Hours
          var min = new Date().getMinutes(); //Current Minutes
          var sec = new Date().getSeconds(); //Current Seconds
          setCurrentDate(
            date + '/' + month + '/' + year 
            + ' ' + hours + ':' + min + ':' + sec
          );
        }, []);
  

   
        return (
        
          <ScrollView >
          <View style={{ justifyContent: 'flex-start', alignItems: 'flex-start', flexDirection: 'row', flex: 1}}>
          <View>
          <NavScreen></NavScreen>
          </View>
          
          <View style={styles.container}>
          <Text style={styles.textStyle}>
            {currentDate}
          </Text>
          <Card  style={styles.card}>
            <Text style={styles.paragraph}>
              Pizza
            </Text>
            <Image source={require('./pizza.jpg')} style={{ width: 90, height: 90,marginLeft:111}} />
          </Card>
          <Card style={styles.card}>
            <Text style={styles.paragraph}>
              Pasta
            </Text>
            <Image source={require('./pasta.jpg')} style={{ width: 90, height: 90,marginLeft:111}} />
          </Card>
          <Card style={styles.card}>
            <Text style={styles.paragraph}>
              Vegtables
            </Text>
            <Image source={require('./vegtables.jpg')} style={{ width: 90, height: 90,marginLeft:111}} />
          </Card>
          <Card style={styles.card}>
            <Text style={styles.paragraph}>
              Vagtables with cutlets
            </Text>
            <Image source={require('./vegtwithescalope.jpg')} style={{ width: 90, height: 90,marginLeft:111}} />
          </Card>
          
        </View>
        
          </View>
          </ScrollView>
    );
};

export default ActScreen;
const styles = StyleSheet.create({
    textStyle: {
        fontSize: 10,
        color: '#F18062',
        marginLeft:200,
        fontFamily:'sans-serif',
        fontStyle:'italic',
        backgroundColor:"#FFF6DA"
    },   
    container: {
      flex: 1,
      justifyContent: 'center',
      paddingLeft:20,
      paddingRight:20   },
    paragraph: {
      fontSize: 18,
      fontWeight: 'bold',
      textAlign: 'center',
      color:'#FFC0F0'
    },
    card:{
        marginTop:30
    }
});