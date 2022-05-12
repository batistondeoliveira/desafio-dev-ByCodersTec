import React from 'react';
import { Redirect, Link } from 'react-router-dom';

const HeaderBottom = () => {
  const menu = [    
    {name: "Importar", link: "/"}, 
    {name: "Relatório", link: "/relatorio"}
  ];

  const [activeIndex, setActiveIndex] = React.useState(0);

  return (
    <div className="header-bottom">
      <nav>
        <ul>
          {menu.map((menu, index) => 
            <li 
              key={index} 
              className={index === activeIndex ? 'active' : ''} 
              onClick={() => setActiveIndex(index)}
            >
              <Link to={menu.link}>
                {menu.name}
              </Link>
            </li>
          )}                  
        </ul>
      </nav>
    </div>
  )
}

export default HeaderBottom;
