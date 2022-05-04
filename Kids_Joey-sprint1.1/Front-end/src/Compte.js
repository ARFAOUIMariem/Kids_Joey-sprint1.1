import React, { Component } from 'react';
      import NavScreenA from './NavScreenA';
      import {
        StyleSheet,
        Text,
        View,
        Image,
        TouchableOpacity,
        FlatList,
        Dimensions,
        Alert,
        ScrollView
      } from 'react-native';
      
      export default class Compte extends Component {
      
        constructor(props) {
          super(props);
          this.state = {
            modalVisible:false,
            userSelected:[],
            data: [
              {id:1,  name: " list des Parent",   image:"https://img.icons8.com/clouds/100/000000/groups.png", lien:"ListParent"},
              {id:2,  name: "List des enfants",    image:"./src/doctor.png" ,lien:"listEnfant"},
              {id:3,  name: "List des medcins",       image:"https://img.icons8.com/color/100/000000/find-matching-job.png", lien:"ListMedcin"} ,
              {id:4,  name: "List des Ensiengant",   image:"https://img.icons8.com/clouds/100/000000/employee-card.png", lien:"ListEnsiengant"} ,
             
            ]
          };
        }
      
      
      
        render() {
          return (
            <View style={{ justifyContent: 'flex-start', alignItems: 'flex-start', flexDirection: 'row', flex: 1}}>
         <View>
          <NavScreenA></NavScreenA>
          </View>
            <View style={styles.container}>
            
                  <TouchableOpacity style={styles.card} onPress={()=> this.props.navigation.navigate('ListParent')}>
                    <Image style={styles.image} source={{uri:" https://img.icons8.com/clouds/100/000000/groups.png"}}/>
                    <View style={styles.cardContent}>
                      <Text style={styles.name}>list des Parent</Text>
    
                    </View>

                  </TouchableOpacity>
                  <TouchableOpacity style={styles.card}  onPress={()=>this.props.navigation.navigate('ListMedcin')}>
                    <Image style={styles.image} source={{uri: "./src/doctor.png"}}/>
                    <View style={styles.cardContent}>
                      <Text style={styles.name}>List des medcins</Text>
                    </View>
                  </TouchableOpacity>
                
                  <TouchableOpacity style={styles.card} onPress={()=> this.props.navigation.navigate('ListEnsiengant')}>
                    <Image style={styles.image} source={{uri:"https://img.icons8.com/clouds/100/000000/employee-card.png"}}/>
                    <View style={styles.cardContent}>
                      <Text style={styles.name}>List des Ensiengant</Text>
                      
                     
                    </View>
                  </TouchableOpacity>
              
            </View>
            </View>

          );
        }
      }
      
    
      const styles = StyleSheet.create({
        container:{
          flex:1,
          marginTop:20,
          backgroundColor:"#ebf0f7"
        },
        contentList:{
          flex:1,
        },
        cardContent: {
          marginLeft:20,
          marginTop:10
        },
        image:{
          width:90,
          height:90,
          borderRadius:45,
          borderWidth:2,
          borderColor:"#ebf0f7"
        },
      
        card:{
          shadowColor: '#00000021',
          shadowOffset: {
            width: 0,
            height: 6,
          },
          shadowOpacity: 0.37,
          shadowRadius: 7.49,
          elevation: 12,
      
          marginLeft: 20,
          marginRight: 20,
          marginTop:20,
          backgroundColor:"white",
          padding: 10,
          flexDirection:'row',
          borderRadius:30,
        },
      
        name:{
          fontSize:18,
          flex:1,
          alignSelf:'center',
          color:"#3399ff",
          fontWeight:'bold'
        },
        count:{
          fontSize:14,
          flex:1,
          alignSelf:'center',
          color:"#6666ff"
        },
        followButton: {
          marginTop:10,
          height:35,
          width:100,
          padding:10,
          flexDirection: 'row',
          justifyContent: 'center',
          alignItems: 'center',
          borderRadius:30,
          backgroundColor: "white",
          borderWidth:1,
          borderColor:"#dcdcdc",
        },
        followButtonText:{
          color: "#dcdcdc",
          fontSize:12,
        },
      }); 