import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import Welcome from './components/Welcome';

// ========================================
class Screen extends React.Component {
  render() {
    return (
      <div className='d1'>
        <Welcome />
      </div>
    );
  }
}

ReactDOM.render(
  <Screen />,
  document.getElementById('root')
);