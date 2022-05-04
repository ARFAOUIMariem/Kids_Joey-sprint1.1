import React, {useState, useEffect}from 'react'
import { Alert, Text } from 'react-native';
import { StyleSheet,Image, View,SafeAreaView,ScrollView} from 'react-native';
import NavScreen from './NavScreen';
import { Avatar,Button, Card, Title, Paragraph } from 'react-native-paper';

const ActScreen= () => {
  const LeftContent = props => <Avatar.Icon {...props} icon="folder" />

    const [currentDate, setCurrentDate] = useState('');
    const months = ["January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"];
    let newDate = new Date()
        useEffect(() => {
          var date = new Date().getDate(); //Current Date
          var month = months[new Date().getMonth() ]; //Current Month
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
              Painting
            </Text>
            <Image source={require('./painting.png')} style={{ width: 90, height: 90,marginLeft:111}} />
          </Card>
          <Card style={styles.card}>
            <Text style={styles.paragraph}>
              Sport
            </Text>
            <Image source={require('./beach-ball.png')} style={{ width: 90, height: 90,marginLeft:111}} />
          </Card>
          <Card style={styles.card}>
            <Text style={styles.paragraph}>
              Puzzle
            </Text>
            <Image source={require('./puzzle.png')} style={{ width: 90, height: 90,marginLeft:111}} />
          </Card>
          <Card style={styles.card}>
            <Text style={styles.paragraph}>
              Lego
            </Text>
            <Image source={require('./blocks.png')} style={{ width: 90, height: 90,marginLeft:111}} />
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
        marginLeft:190,
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