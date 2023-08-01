import React, { useState } from 'react'
import Form from 'react-bootstrap/Form'
import Row from 'react-bootstrap/Row';
import Button from 'react-bootstrap/Button'
import { saveDog } from '../services/dog-service';

const DogForm = () => {
    const [dog_id, setDogId] = useState(0);
    const [name, setName] = useState('');
    const [age, setAge] = useState(0);

    const handleDogIdChange = (event) => {
        setDogId(event.target.value);
    }

    const handleNameChange = (event) => {
        setName(event.target.value);
    }

    const handleAgeChange = (event) => {
        setAge(event.target.value)
    }


    const handleSubmit =(event)=>{
        event.preventDefault();
        let dog = {};
        dog.dog_id = dog_id;
        dog.name = name;
        dog.age = age;
        saveDog(dog)
        .then(res => {
            setDogId(0);
            setName('');
            setAge(0)
            })
          .catch(err=>{
             console.log(err);
            })   ;
      }

    return (
        <Row className='heroForm'>
            <Form >
                <Form.Group className="mb-3" controlId="dog_id">
                    <Form.Label>Dog Id: </Form.Label>
                    <Form.Control type="text" placeholder="Dog Id" value={dog_id}
                        onChange={handleDogIdChange} />
                </Form.Group>
                <Form.Group className="mb-3" controlId="name">
                    <Form.Label>Dog Name: </Form.Label>
                    <Form.Control type="text" placeholder="Dog name" value={name}
                        onChange={handleNameChange} />
                </Form.Group>
                <Form.Group className="mb-3" controlId="age">
                    <Form.Label>Dog Age: </Form.Label>
                    <Form.Control type="text" placeholder="Dog age" value={age}
                        onChange={handleAgeChange} />
                </Form.Group>
                <Button variant="primary" type="submit" onClick={handleSubmit}>
                    Submit
                </Button>
            </Form>
        </Row>
    )
}

export default DogForm