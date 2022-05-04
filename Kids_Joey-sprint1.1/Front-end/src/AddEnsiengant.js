import * as React from 'react';
import { Text, View, StyleSheet, TextInput, Button, Alert } from 'react-native';
import { useForm, Controller } from 'react-hook-form';
import Constants from 'expo-constants';

export default AddEnsiengant  => {
  const { register, setValue, handleSubmit, control, reset, formState: { errors } } = useForm({
    defaultValues: {
      firstName: '',
      lastName: ''
    }
  });
  const onSubmit = data => {
    console.log(data);
    alert('You tapped the button!');
    this.props.navigation.navigate('ListEnsiengant');
  };

  const onChange = arg => {
    return {
      value: arg.nativeEvent.text,
    };
  };

  console.log('errors', errors);

  return (
    <View style={styles.container}>
   
      
      <Text style={styles.label}>Username</Text>
      <Controller
        control={control}
        render={({field: { onChange, onBlur, value }}) => (
          <TextInput
            style={styles.input}
            onBlur={onBlur}
            onChangeText={value => onChange(value)}
            value={value}
          />
        )}
        name="Username"
        rules={{ required: true }}
      />
      <Text style={styles.label}>Password</Text>
      <Controller
        control={control}
        render={({field: { onChange, onBlur, value }}) => (
          <TextInput
            style={styles.input}
            onBlur={onBlur}
            onChangeText={value => onChange(value)}
            value={value}
          />
        )}
        name="Password"
        rules={{ required: true }}
      />
      <View style={styles.button}>
        <Button
          style={styles.buttonInner}
          color
          title="Ajouter"
          onPress={handleSubmit(onSubmit)}
        />
      </View>
  
    </View>
  );
}


const styles = StyleSheet.create({
  text:{    
    fontWeight: 'bold',
    fontSize: 400,
    justifyContent: 'center',
    color: '#ec5990',
},
  label: {
    fontWeight: 'bold',
    margin: 20,
    marginLeft: 0,
  },
  button: {
    marginTop: 40,
    color: 'white',
    height: 40,
    backgroundColor: '#ec5990',
    borderRadius: 4,
  },
  container: {
    flex: 1,
    paddingTop: Constants.statusBarHeight,
    padding: 8,
  
  },
  buttonInner:{
    fontWeight: 'bold',
    fontSize: 150,
    justifyContent: 'center',
  },
  input: {
    backgroundColor: 'white',
    borderColor: 'none',
    height: 40,
    padding: 10,
    borderRadius: 20
  },
});