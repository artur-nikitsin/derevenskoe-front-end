import React, {Component} from 'react';
import {connect} from 'react-redux'
import {Container} from '@material-ui/core';
import Vegetables from "./vegetables/Vegetables";
import Zakatki from "./zakatki/Zakatki";
import Jam from "./jam/Jam";
import Dumplings from "./dumplings/Dumplings";
import MilkProducts from "./milk_products/MilkProducts";
import Bread from "./bread/Bread";
import Meat from "./meat/Meat";
import EggsHoney from "./eggs_honey/EggsHoney";

import Oils from "./oils/Oils";
import Tea from "./tea/Tea";
import Other from "./other/Other";


import {BrowserRouter as Router, Route, Link} from "react-router-dom";


class Catalog extends Component {

    constructor(props) {
        super(props);
    }



    render() {


        return (
            <Container>
                <div><p>Catalog</p></div>
                <Route path='/catalog/vegetables' component={Vegetables}/>
                <Route path='/catalog/zakatki' component={Zakatki}/>
                <Route path='/catalog/jam' component={Jam}/>
                <Route path='/catalog/dumplings' component={Dumplings}/>
                <Route path='/catalog/milk_products' component={MilkProducts}/>
                <Route path='/catalog/bread' component={Bread}/>
                <Route path='/catalog/meat' component={Meat}/>
                <Route path='/catalog/eggs_honey' component={EggsHoney}/>
                <Route path='/catalog/oils' component={Oils}/>
                <Route path='/catalog/tea' component={Tea}/>
                <Route path='/catalog/other' component={Other}/>
            </Container>
        );
    }

}

export default Catalog;