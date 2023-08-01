import React from 'react'
import DogDetail from './DogDetail'
import { useState } from 'react';
import { useEffect } from 'react';
import { getAllDogs } from '../services/dog-service';
import { Row } from 'react-bootstrap';

function AllDogs() {

  const [total, setTotal] = useState(0);
    // const totalCountHandler = (name) => {
    //     console.log(name)
    //     setTotal(total + 1);
    // }


  const [dogs, setDogs] = useState([]);
    useEffect(() => {
        getDogsFromAPI();
    },
        []
    );
    const getDogsFromAPI = () => {
      console.log(getAllDogs());
      getAllDogs()  
  .then(res => {
      setDogs(res.data);
      setTotal(res.data.length);
  })
  .catch(err => {
      setDogs([]);
      console.log(err);
  })
     }

    return (
        <>
            <h1> Total count is: {total}</h1>
            <Row >
                {dogs.map(dog => (
                    <div className='container' key={dog.dog_id.toString()}>
                        <DogDetail info={dog}/>
                    </div>
                ))}
            </Row>
        </>
    )

}

export default AllDogs