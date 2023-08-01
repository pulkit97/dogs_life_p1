import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import { Routes } from 'react-router-dom';
import { Route } from 'react-router-dom';
import AllDogs from './components/AllDogs';
import DogForm from './components/DogForm';


function App() {
  return (
  <>
      <Navbar expand="lg" className="bg-body-tertiary">
        <Container>
          <Navbar.Brand href="/">Dogs</Navbar.Brand>
          <Navbar.Toggle aria-controls="basic-navbar-nav" />
          <Navbar.Collapse id="basic-navbar-nav">
            <Nav className="me-auto">
              <Nav.Link href="/dogs">All Dogs</Nav.Link>
              <Nav.Link href="/adddogs">Add Dog</Nav.Link>
            </Nav>
          </Navbar.Collapse>
        </Container>
      </Navbar> 
      
        <Routes>
          <Route path="dogs" element={<AllDogs/>} />
           <Route path="adddogs" element={<DogForm/>} /> 
           <Route path="/" element={<AllDogs/>} /> 
        </Routes> 
  </>
      
  );
}

export default App;
