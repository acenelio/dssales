import './App.css';
import Filter from './components/filter';
import Header from './components/header';
import SalesByDate from './components/sales-by-date';

function App() {
  return (
    <>
      <Header />
      <div className="app-container">
        <Filter />
        <SalesByDate />
      </div>
    </>
  );
}

export default App;
