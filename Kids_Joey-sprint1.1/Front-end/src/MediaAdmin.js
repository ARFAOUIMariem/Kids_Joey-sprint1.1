import React, { Component } from 'react';
import NavScreenA from './NavScreenA';
import {
  StyleSheet,
  Text,
  View,
  TouchableOpacity,
  Image,
  Alert,
  ScrollView,
  FlatList,
  Button
} from 'react-native';

export default class MediaAdmin extends Component {

  constructor(props) {
    super(props);
    this.state = {
      data: [
        {id:1, title: "Lorem ipsum dolor",                  time:"2018-08-01 12:15 pm", image:"https://via.placeholder.com/400x200/FFB6C1/000000", description:"Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean  ligula..."},
        {id:2, title: "Sit amet, consectetuer",             time:"2018-08-12 12:00 pm", image:"https://via.placeholder.com/400x200/7B68EE/000000", description:"Lorem  dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula..."} ,
        {id:3, title: "Dipiscing elit. Aenean ",            time:"2017-08-05 12:21 pm", image:"https://via.placeholder.com/400x200/000080/000000", description:"Lorem ipsum dolor sit , consectetuer  elit. Aenean commodo ligula..."}, 
        {id:4, title: "Commodo ligula eget dolor.",         time:"2015-08-12 12:00 pm", image:"https://via.placeholder.com/400x200/48D1CC/000000", description:"Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula..."}, 
        {id:5, title: "Aenean massa. Cum sociis",           time:"2013-06-12 12:11 pm", image:"https://via.placeholder.com/400x200/9370DB/000000", description:"Lorem ipsum dolor sit amet, consectetuer adipiscing elit.  commodo ligula..."}, 
        {id:6, title: "Natoque penatibus et magnis",        time:"2018-08-12 12:56 pm", image:"https://via.placeholder.com/400x200/DA70D6/000000", description:"Lorem ipsum  sit amet, consectetuer adipiscing elit. Aenean commodo ligula..."}, 
        
       
      ]
    };
  }

  render() {
    return (
      <>
       <View style={{ justifyContent: 'flex-start', alignItems: 'flex-start', flexDirection: 'row', flex: 1}}>
       <NavScreenA></NavScreenA>

      <View style={styles.container}>
      <>
      <View style={styles.button2}>
        <Button
          
          
          title="Ajouter"
          onPress={() =>this.props.navigation.navigate('AddMedia')}></Button>
          
     
      </View>

      
        <FlatList style={styles.list}
          data={this.state.data}
          keyExtractor= {(item) => {
            return item.id;
          }}
          ItemSeparatorComponent={() => {
            return (
              <View style={styles.separator}/>
            )
          }}
          renderItem={(post) => {
            const item = post.item;
            return (

              <View style={styles.card}>
                <Image style={styles.cardImage} source={{uri:item.image}}/>
                <View style={styles.cardHeader}>
                  <View>
                    <Text style={styles.title}>{item.title}</Text>
                    <Text style={styles.description}>{item.description}</Text>
                    <View style={styles.timeContainer}>
                      <Image style={styles.iconData} source={{uri: 'https://img.icons8.com/color/96/3498db/calendar.png'}}/>
                      <Text style={styles.time}>{item.time}</Text>
                    </View>
                  </View>
                </View>
                <View style={styles.cardFooter}>
                  <View style={styles.socialBarContainer}>
                    <View style={styles.socialBarSection}>
                      <TouchableOpacity style={styles.socialBarButton} onPress={() => this.props.navigation.navigate('MediaDetail')} >
                        <Image style={styles.icon} source={{uri: 'https://img.icons8.com/more'}}/>
                        <Text style={styles.socialBarLabel}> More</Text>
                      </TouchableOpacity>
                  
                    </View>
                    
                    
                    </View>
                  </View>
                </View>
             
            )
          }}/>
          </>
      </View>
      </View>
      </>
    );
  }
}

const styles = StyleSheet.create({
  button2: {
    marginTop: 30,
    color: 'white',
    height: 30,
    backgroundColor: '#FFC0F0',
    borderRadius: 5,
  
  },
  container:{
    flex:1,
    marginTop:20,
  },
  list: {
    paddingHorizontal: 17,
    backgroundColor:"#E6E6E6",
  },
  separator: {
    marginTop: 10,
  },
 
  /******** card **************/
  card:{
    shadowColor: '#00000021',
    shadowOffset: {
      width: 2
    },
    shadowOpacity: 0.5,
    shadowRadius: 4,
    marginVertical: 8,
    backgroundColor:"white"
  },
  cardHeader: {
    paddingVertical: 17,
    paddingHorizontal: 16,
    borderTopLeftRadius: 1,
    borderTopRightRadius: 1,
    flexDirection: 'row',
    justifyContent: 'space-between',
  },
  cardContent: {
    paddingVertical: 12.5,
    paddingHorizontal: 16,
  },
  cardFooter:{
    flexDirection: 'row',
    justifyContent: 'space-between',
    paddingTop: 12.5,
    paddingBottom: 25,
    paddingHorizontal: 16,
    borderBottomLeftRadius: 1,
    borderBottomRightRadius: 1,
    backgroundColor:"#EEEEEE",
  },
  cardImage:{
    flex: 1,
    height: 150,
    width: null,
  },
  /******** card components **************/
  title:{
    fontSize:18,
    flex:1,
  }, 
  description:{
    fontSize:15,
    color:"#888",
    flex:1,
    marginTop:5,
    marginBottom:5,
  },
  time:{
    fontSize:13,
    color: "#808080",
    marginTop: 5
  },
  icon: {
    width:25,
    height:25,
  },
  iconData:{
    width:15,
    height:15,
    marginTop:5,
    marginRight:5
  },
  timeContainer:{
    flexDirection:'row'
  },
  /******** social bar ******************/
  socialBarContainer: {
    justifyContent: 'center',
    alignItems: 'center',
    flexDirection: 'row',
    flex: 1
  },
  socialBarSection: {
    justifyContent: 'center',
    flexDirection: 'row',
    flex: 1,
  },
  socialBarlabel: {
    marginLeft: 8,
    alignSelf: 'flex-end',
    justifyContent: 'center',
  },
  socialBarButton:{
    flexDirection: 'row',
    justifyContent: 'center',
    alignItems: 'center',
  }
});  