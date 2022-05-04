/*import React, { useState, useRef } from 'react';
import Carousel, { Pagination } from 'react-native-snap-carousel';

import {
  TouchableOpacity,
  View,
  Text,
  Image,
  FlatList,
  Dimensions
} from 'react-native';

const { width } = Dimensions.get('window');
const SPACING = 10;
const THUMB_SIZE = 80;

const IMAGES = {
  image1: require('./1.jpg'),
  image2: require('./2.png'),
  image3: require('./3.jpg'),
  image4: require('./4.jpg'),
  image5: require('./5.jpg'),
  image6: require('./6.jpg'),

};

const MediaDetail = () => {
  const [images, setImages] = useState([
    { id: '1', image: IMAGES.image1 },
    { id: '2', image: IMAGES.image2 },
    { id: '3', image: IMAGES.image3 },
    { id: '4', image: IMAGES.image4 },
    { id: '5', image: IMAGES.image5 },
    { id: '6', image: IMAGES.image6 },
 
  ]);

  return (
     
   
    <View style={{ flex: 1, backgroundColor: 'black', alignItems: 'center' }}>
     <Text
        style={{
          color: 'white',
          fontSize: 32,
          marginTop: 50,
          marginBottom: 25
        }}
      >
        Custom Gallery
      </Text>
   
    <View style={{ flex: 1 / 2, marginTop: 20 }}>
      <Carousel
        layout='default'
        data={images}
        sliderWidth={width}
        itemWidth={width}
        renderItem={({ item, index }) => (
          <Image
            key={index}
            style={{ width: '100%', height: '100%' }}
            resizeMode='contain'
            source={item.image}
          />
        )}
      />
    </View>
  </View>

  );
};

export default MediaDetail;*/