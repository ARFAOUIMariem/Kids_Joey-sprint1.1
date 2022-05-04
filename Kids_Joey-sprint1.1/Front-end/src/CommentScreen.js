import React, {useState, useEffect}from 'react'
import { Alert, Text } from 'react-native';
import { StyleSheet,Image, View,SafeAreaView,ScrollView,TextInput,TouchableOpacity} from 'react-native';
import NavScreen from './NavScreen';
import { Avatar,Button, Card, Title, Paragraph } from 'react-native-paper';
import { Formik,Form,Fiel } from 'formik';
const CommentScreen =() =>{
    const [text, onChangeText] = React.useState("");
    const [answer, onChangeAnswer] = React.useState("hello");
    const [currentDate, setCurrentDate] = useState('');
    const [currentDay, setCurrentDay] = useState('');
    const [currentMonth, setCurrentMonth] = useState('');
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
          setCurrentDay(
            date 
          );
          setCurrentMonth(
            month 
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
          <Card style={styles.card}>
          <View style={styles.box}><Text style={styles.text}>{currentDay}</Text><Text style={styles.text}>{currentMonth}</Text></View>

        <Formik
     onSubmit={values => console.log(values)}
   >
     {({ handleChange, handleBlur, handleSubmit, values }) => (
       <View>
         <TextInput
         multiline
         numberOfLines={3}
         style={styles.input}
         onChangeText={onChangeText}
         value={text}
         placeholder="put your comment"
         keyboardType="ascii-capable"
         />
                  <Button style={styles.loginBtn} onPress={handleSubmit} >Add</Button>

         <TextInput
        multiline
        numberOfLines={3}
        style={styles.input}
        onChangeText={onChangeAnswer}
        value={answer}
        placeholder="Admin answer"
        keyboardType="ascii-capable"
            />
       </View>
     )}
   </Formik>
        </Card>
         
          </View>
          
          </View></ScrollView>
    )
    }
    
    export default CommentScreen;
    const styles = StyleSheet.create({
        textStyle: {
            fontSize: 10,
            color: '#F18062',
            marginLeft:180,
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
            marginTop:30,
            backgroundColor:'#DBFFF8'
        },
        card1:{
            marginTop:30,
            backgroundColor:'#DBFFF8'
        },
        input: {
            margin: 12,
            borderWidth: 1,
            borderColor:'white'
          },
        
        box:{
            width: 50,
            height:50,
            backgroundColor:'#1CC6AD',
            borderRadius:5,
            margin:5
        },
        text:{
            color:'#DBFFF8',
            marginLeft:10
        },
        loginBtn:
   {
     width:"50%",
     borderRadius:10,
     backgroundColor:"#1CC6AD",
     marginLeft:150,
   }
    });
   