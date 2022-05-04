import * as React from 'react';
import { NavigationContainer } from '@react-navigation/native';
import { createStackNavigator } from '@react-navigation/stack';
import { Button,Text,Image,StyleSheet } from 'react-native';
import HomeScreen from './src/HomeScreen';
import ProfileScreen from './src/ProfileScreen';
import AuthScreen from './src/auth';
import NavScreen from './src/NavScreen';
import ActScreen from './src/ActScreen';
import Planning from './src/Planning';
import HomeP from './src/HomeP';
import Meals from './src/Meals';
import MediaScreen from './src/MediaScreen';
import EnfantScreen from './src/EnfantScreen';
import SettingScreen from './src/SettingScreen';
import ActivityA from './src/ActivityA';
import NavScreenA from './src/NavScreenA';
import AddAct from './src/AddAct';
import CommentScreen from './src/CommentScreen';
import CommentScreenA from './src/CommentScreenA';
import AnswerScreen from './src/AnswerScreen';
import Compte from './src/Compte';
import ListParent from './src/ListParent';
import ListMedcin from './src/ListMedcin';
import ListEnsiengant from './src/ListEnsiengant';
import CompteDetailParent from './src/CompteDetailParent';
import CompteDetailMedcin from './src/CompteDetailMedcin'
import CompteDetail from './src/CompteDetail';

import MediaAdmin from './src/MediaScreen';
import AddEnsiengant from './src/AddEnsiengant';
import HomeE from './src/HomeE';
import NavScreenE from './src/NavScreenE';
import AddMedcin from './src/AddMedcin';
import AddParent from './src/AddParent';
import UpdateCompte from './src/UpdateCompte';
import MealScreen from './src/MealScreen';


const Stack = createStackNavigator();

const MyStack = () => {
  
  return (
    <NavigationContainer >
      <Stack.Navigator >
        <Stack.Screen
          name="  "
          component={HomeContainer}
        />


        <Stack.Screen name="Profile" options={{ 
      title: <Image style={{ width:130,height:30}}
      source = {require('./src/kan.png')}/> ,headerStyle: {
        backgroundColor: '#FFC0F0',
      },headerTintColor: '#fff',headerTitleStyle: {
        fontWeight: 'bold',
      },
    }} component={ProfileScreen} />


    <Stack.Screen name="Auth" options={{ title: 'Authentication',headerStyle: {
            backgroundColor: '#FFC0F0',
          },headerTintColor: '#fff',headerTitleStyle: {
            fontWeight: 'bold',
          },
    }} component={AuthScreen} />


    <Stack.Screen name="Nav" options={{ 
      title: <Image style={{ width:130,height:30}}
      source = {require('./src/kan.png')}/> , 
    }}  component={NavScreen} />
    <Stack.Screen name="Meal" options={{
          title:'Meals',headerStyle: {
                backgroundColor: '#FFC0F0',
              },headerTintColor: '#fff',headerTitleStyle: {
                fontWeight: 'bold',
              },
        }}  component={MealScreen} />

    <Stack.Screen name="NavA" options={{ 
      title: <Image style={{ width:130,height:30}}
      source = {require('./src/kan.png')}/> , 
    }}  component={NavScreenA} />

    <Stack.Screen name="Act" options={{ 
      title:'Activities',headerStyle: {
            backgroundColor: '#FFC0F0',
          },headerTintColor: '#fff',headerTitleStyle: {
            fontWeight: 'bold',
          }, 
    }}  component={ActScreen} />


    <Stack.Screen name="Planning" options={{ 
      title:'Planning',headerStyle: {
            backgroundColor: '#FFC0F0',
          },headerTintColor: '#fff',headerTitleStyle: {
            fontWeight: 'bold',
          }, 
    }}  component={Planning} />


    <Stack.Screen name="HomeP" options={{ 
      title: <Image style={{ width:130,height:30}}
      source = {require('./src/kan.png')}/> 
    }}  component={HomeP} />


    <Stack.Screen name="Meals" options={{ 
      title: <Image style={{ width:130,height:30}}
      source = {require('./src/kan.png')}/> 
    }}  component={Meals} />


    <Stack.Screen name="MediaScreen" options={{ 
      title: <Image style={{ width:130,height:30}}
      source = {require('./src/kan.png')}/> 
    }}  component={MediaScreen} />


        <Stack.Screen name="EnfantScreen" options={{ 
      title: <Image style={{ width:130,height:30}}
      source = {require('./src/kan.png')}/> 
    }}  component={EnfantScreen} />


     <Stack.Screen name="SettingScreen" options={{ 
      title: <Image style={{ width:130,height:30}}
      source = {require('./src/kan.png')}/> 
    }}  component={SettingScreen} />

      <Stack.Screen name="ActivityA" options={{ 
      title:'Activities',headerStyle: {
            backgroundColor: '#FFC0F0',
          },headerTintColor: '#fff',headerTitleStyle: {
            fontWeight: 'bold',
          }, 
    }}  component={ActivityA} />

    <Stack.Screen name="AddAct" options={{ 
      title:'Add',headerStyle: {
            backgroundColor: '#FFC0F0',
          },headerTintColor: '#fff',headerTitleStyle: {
            fontWeight: 'bold',
          }, 
    }}  component={AddAct} />

<Stack.Screen name="Comment" options={{ 
      title:'Comments',headerStyle: {
            backgroundColor: '#FFC0F0',
          },headerTintColor: '#fff',headerTitleStyle: {
            fontWeight: 'bold',
          }, 
    }}  component={CommentScreen} />

<Stack.Screen name="CommentA" options={{ 
      title:'Comments',headerStyle: {
            backgroundColor: '#FFC0F0',
          },headerTintColor: '#fff',headerTitleStyle: {
            fontWeight: 'bold',
          }, 
    }}  component={CommentScreenA} />
    <Stack.Screen name="AnswerScreen" options={{ 
      title:'AnswerScreen',headerStyle: {
            backgroundColor: '#FFC0F0',
          },headerTintColor: '#fff',headerTitleStyle: {
            fontWeight: 'bold',
          }, 
    }}  component={AnswerScreen} />


            <Stack.Screen name="Compte" options={{
            title:'Compte',headerStyle: {
                  backgroundColor: '#FFC0F0',
                },headerTintColor: '#fff',headerTitleStyle: {
                  fontWeight: 'bold',
                },
          }}  component={Compte} />
          <Stack.Screen name="ListParent" options={{
            title:'ListParent',headerStyle: {
                  backgroundColor: '#FFC0F0',
                },headerTintColor: '#fff',headerTitleStyle: {
                  fontWeight: 'bold',
                },
          }}  component={ListParent} />
            <Stack.Screen name="ListMedcin" options={{
            title:'ListMedcin',headerStyle: {
                  backgroundColor: '#FFC0F0',
                },headerTintColor: '#fff',headerTitleStyle: {
                  fontWeight: 'bold',
                },
          }}  component={ListMedcin} />

           <Stack.Screen name="ListEnsiengant" options={{
                title:'ListEnsiengant',headerStyle: {
                  backgroundColor: '#FFC0F0',
                },headerTintColor: '#fff',headerTitleStyle: {
                  fontWeight: 'bold',
                },
          }}  component={ListEnsiengant} />
          <Stack.Screen name="CompteDetail" options={{
                title:'CompteDetail',headerStyle: {
                  backgroundColor: '#FFC0F0',
                },headerTintColor: '#fff',headerTitleStyle: {
                  fontWeight: 'bold',
                },
          }}  component={CompteDetail} />

      <Stack.Screen name="CompteDetailMedcin" options={{
                title:'CompteDetailMedcin',headerStyle: {
                  backgroundColor: '#FFC0F0',
                },headerTintColor: '#fff',headerTitleStyle: {
                  fontWeight: 'bold',
                },
          }}  component={CompteDetailMedcin} />

      <Stack.Screen name="CompteDetailParent" options={{
                title:'CompteDetailParent',headerStyle: {
                  backgroundColor: '#FFC0F0',
                },headerTintColor: '#fff',headerTitleStyle: {
                  fontWeight: 'bold',
                },
          }}  component={CompteDetailParent} />

      </Stack.Navigator>
    </NavigationContainer>
  );
};

export default MyStack;
