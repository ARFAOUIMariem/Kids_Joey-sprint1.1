import React, {useState, useEffect} from 'react'
import { Alert, Text } from 'react-native';
import { StyleSheet,Image, View,SafeAreaView,ScrollView,TextInput,TouchableOpacity} from 'react-native';
import NavScreenA from './NavScreenA';
import { Avatar,Button, Card, Title, Paragraph,IconButton,Searchbar } from 'react-native-paper';
import Icon from "react-crud-icons";

const ActivityA = ({navigation}) => {
  const [Activity, setActivity] = useState('');
  const [picture, setPicture] = useState('');
  const [searchQuery, setSearchQuery] = React.useState('');

  const onChangeSearch = query => setSearchQuery(query);

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
          <NavScreenA></NavScreenA>
          </View>
          
          <View style={styles.container}>
          <Text style={styles.textStyle}>
            {currentDate}
          </Text>
          
          <TouchableOpacity style={styles.loginBtn}>
            <Button style={styles.loginText} onPress={() =>navigation.navigate('AddAct')}>Add</Button>
          </TouchableOpacity>
          <Searchbar style={{marginTop:20}}
      placeholder="Search"
      onChangeText={onChangeSearch}
      value={searchQuery}
    />
          <Card  style={styles.card}>
            <Text style={styles.paragraph}>
              Painting
            </Text>
            <Image source={require('./painting.png')} style={{ width: 90, height: 90,marginLeft:111}} />
            <View style={{ flexDirection: 'row'}}>
            <IconButton icon="border-color" color='green' size={20} onPress={() =>Alert.alert('Activity edited')} />
            <IconButton icon="trash-can" color='red' size={20} onPress={() => Alert.alert('Activity removed')} /></View>
          </Card>
          <Card style={styles.card}>
            <Text style={styles.paragraph}>
              Sport
            </Text>
            <Image source={require('./beach-ball.png')} style={{ width: 90, height: 90,marginLeft:111}} />
            <View style={{ flexDirection: 'row'}}>
            <IconButton icon="border-color" color='green' size={20} onPress={() => Alert.alert('Activity edited')} />
            <IconButton icon="trash-can" color='red' size={20} onPress={() => Alert.alert('Activity removed')} /></View>
          </Card>
          <Card style={styles.card}>
            <Text style={styles.paragraph}>
              Puzzle
            </Text>
            <Image source={require('./puzzle.png')} style={{ width: 90, height: 90,marginLeft:111}} />
            <View style={{ flexDirection: 'row'}}>
            <IconButton icon="border-color" color='green' size={20} onPress={() => Alert.alert('Activity edited')} />
            <IconButton icon="trash-can" color='red' size={20} onPress={() => Alert.alert('Activity removed')} /></View>
          </Card>
          <Card style={styles.card}>
            <Text style={styles.paragraph}>
              Lego
            </Text>
            <Image source={require('./blocks.png')} style={{ width: 90, height: 90,marginLeft:111}} />
            <View style={{ flexDirection: 'row'}}>
            <IconButton icon="border-color" color='green' size={20} onPress={() => Alert.alert('Activity edited')} />
            <IconButton icon="trash-can" color='red' size={20} onPress={() => Alert.alert('Activity removed')} /></View>
          </Card>
         

        </View>
        
          </View>
          </ScrollView>
    );
        
};

export default ActivityA;
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
      paddingRight:20  },

    paragraph: {
      fontSize: 18,
      fontWeight: 'bold',
      textAlign: 'center',
      color:'#FFC0F0'
    },
    card:{
        marginTop:30
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
        backgroundColor: "#F5F0FF",
        borderRadius: 30,
        width: "70%",
        height: 45,
        marginBottom: 20,
        alignItems: "center",
      },
      forgot_button: {
        height: 30,
        marginBottom: 30,
      },
      loginBtn:
 {
   width:"50%",
   borderRadius:25,
   backgroundColor:"#FFC0F0",
   marginTop:20
 }
});