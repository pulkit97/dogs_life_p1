import React from 'react'
import Card from 'react-bootstrap/Card';


const DogDetail = (props) => {
    // const [counter, setCounter] = useState(0);
    // const incrementCounter =()=>{
    //     setCounter(counter+1);
    //     props.parentCount(props.info.alias);
    // }

    return (
        <Card >
            <Card.Body >
                <Card.Title >Name: {props.info.name}</Card.Title>
                <Card.Text >Age: {props.info.age}</Card.Text>
            </Card.Body>
        </Card>)
}

export default DogDetail