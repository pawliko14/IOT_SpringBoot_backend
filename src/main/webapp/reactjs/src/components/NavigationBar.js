import React from 'react';

import {Navbar,Nav} from 'react-bootstrap';
import {Link} from 'react-router-dom';

class NavigationBar extends React.Component {


    render(){
        return (
        <Navbar  bg="dark" variant="dark">
            <Link to ={""} className="navbar-brand">
                HOME
            </Link>
             <Nav className="mr-auto">
                <Link to = {"currentstate"} className="nav-link"> Current State</Link>
                <Link to = {"activeworkers"} className="nav-link"> Active Workers</Link>
                <Link to = {"lastactivities"} className="nav-link"> last Activities</Link>
                <Link to = {"Statistics"} className="nav-link"> Statistics</Link>
                <Link to = {"HistoricalData"} className="nav-link"> HistoricalData</Link>
              </Nav>
              <Nav className="navbar-right">
                <Link to = {"Logout"} className="nav-link"> Logout</Link>
                 <Link to = {"Login"} className="nav-link"> Login</Link>
              </Nav>
        </Navbar>
        );
    }
}

export default NavigationBar;