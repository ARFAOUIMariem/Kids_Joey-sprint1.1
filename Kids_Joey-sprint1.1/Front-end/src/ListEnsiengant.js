
import React, { Component } from 'react';
import NavScreenA from './NavScreenA';
import UpdateCompte from './UpdateCompte';

import {
  StyleSheet,
  Text,
  View,
  TextInput,
  Button,
  TouchableHighlight,
  Alert,
  Image,
  FlatList,
  TouchableOpacity
} from 'react-native';

export default class ListEnsiengant extends Component {

  constructor(props) {
    super(props);
    this.state = {
      data: [
         {id:1, image: "https://bootdey.com/img/Content/avatar/avatar1.png"},
         {id:2, image: "https://bootdey.com/img/Content/avatar/avatar6.png"},
         {id:3, image: "https://bootdey.com/img/Content/avatar/avatar2.png"},
         {id:4, image: "https://bootdey.com/img/Content/avatar/avatar3.png"},
         {id:5, image: "https://bootdey.com/img/Content/avatar/avatar4.png"},
      ],
    };
  }

  render() {
    return (


       <>
       <View style={{ justifyContent: 'flex-start', alignItems: 'flex-start', flexDirection: 'row', flex: 1}}>
       <NavScreenA></NavScreenA>


        <View style={styles.container}>


          <View style={styles.button2}>
        <Button
          style={styles.buttonInner}

          title="Add"
          onPress={() =>this.props.navigation.navigate('AddEnsiengant')}
        />
      </View>

        <View style={styles.formContent}>
          <View style={styles.inputContainer}>
            <Image style={[styles.icon, styles.inputIcon]} source={{uri: 'https://png.icons8.com/search/androidL/100/000000'}}/>
            <TextInput style={styles.inputs}
                ref={'txtPassword'}
                placeholder="Search"
                underlineColorAndroid='transparent'
                onChangeText={(name_address) => this.setState({name_address})}/>
          </View>
        </View>
       <FlatList
        enableEmptySections={true}
        data={this.state.data}
        keyExtractor={(item) => {
          return item.id;
        } }

        renderItem={({ item }) => {
          return (

            <View style={styles.box}>
              <Image style={styles.image} source={{ uri: item.image }} />
              <View style={styles.boxContent}>
                <Text style={styles.title}>Title</Text>
                <Text style={styles.description}>Lorem ipsum dolor sit amet, elit consectetur</Text>
                <View style={styles.buttons}>
                  <TouchableHighlight style={[styles.button, styles.view]} onPress={() => Alert.alert('account removed')}>
                    <Image style={styles.icon} source={{ uri: 'https://img.icons8.com/color/trash' }} />

                  </TouchableHighlight>

                  <TouchableHighlight style={[styles.button, styles.profile]} onPress={() => this.props.navigation.navigate('UpdateCompte')}>
                    <Image style={styles.icon} source={{ uri: 'https://img.icons8.com/color/edit' }} />
                  </TouchableHighlight>

                  <TouchableHighlight style={[styles.button, styles.message]} onPress={() => this.clickListener('login')}>
                    <Image style={styles.icon} source={{ uri: 'https://img.icons8.com/details' }} />
                  </TouchableHighlight>
                </View>
              </View>
            </View>
          );
        } } />
        </View>
</View>
        </>

    );
  }
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    paddingLeft:20,
    paddingRight:20    },
  image: {
    width: 100,
    height:100,
  },
  box: {
    padding:20,
    marginTop:5,
    marginBottom:5,
    backgroundColor: 'white',

  },
  button2: {
    marginTop: 40,
    color: 'white',
    height: 40,
    backgroundColor: '#ec5990',
    borderRadius: 4,
  },

  boxContent: {
    flex:1,

    alignItems: 'flex-start',
    marginLeft:10,
  },
  title:{
    fontSize:18,
    color:"#151515",
  },
  description:{
    fontSize:15,
    color: "#646464",
  },
  buttons:{
    flexDirection: 'row',
  },
  button: {
    height:35,
    flexDirection: 'row',
    justifyContent: 'center',
    alignItems: 'center',
    borderRadius:10,
    width:50,
    marginRight:5,
    marginTop:5,
  },
  icon:{
    width:20,
    height:20,
  },
  formContent:{
    flexDirection: 'row',
    marginTop:30,
  },
  inputContainer: {
      borderBottomColor: '#F5FCFF',
      backgroundColor: '#FFFFFF',
      borderRadius:30,
      borderBottomWidth: 1,
      height:45,
      flexDirection: 'row',
      alignItems:'center',
      flex:1,
      margin:10,
  },

  iconBtnSearch:{
    alignSelf:'center'
  },
  inputs:{
      height:45,
      marginLeft:16,
      borderBottomColor: '#FFFFFF',
      flex:1,
  },
  view: {
    backgroundColor: "#eee",
  },
  profile: {
    backgroundColor: "#1E90FF",
  },
  message: {
    backgroundColor: "#228B22",
  },
  forgot_button: {
    height: 30,
    marginBottom: 30,
  },
  loginBtn:{
   width:"50%",
  borderRadius:25,
   backgroundColor:"#FFC0F0",
   marginTop:20
}
});
