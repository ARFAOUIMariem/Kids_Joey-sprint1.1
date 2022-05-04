import React, {useState, useEffect}from 'react'
import { Alert, Text } from 'react-native';
import { StyleSheet,Image, View,SafeAreaView,Button,ScrollView } from 'react-native';
import NavScreen from './NavScreen';

const HomeP= () => {
    const [currentDate, setCurrentDate] = useState('');
    const months = ["January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"];
    let newDate = new Date()
        useEffect(() => {
          var date = new Date().getDate(); //Current Date
          var month = months[new Date().getMonth()]; //Current Month
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
        <Text style={styles.textStyle}>
            {currentDate}
          </Text>
         </View>
         </ScrollView>
    )
}
export default HomeP
const styles = StyleSheet.create({
    textStyle: {
        fontSize: 10,
        color: '#F18062',
        marginLeft:190,
        fontFamily:'sans-serif',
        fontStyle:'italic',
        backgroundColor:'#FFF6DA',
        marginRight:10

      },
 
    }
    );