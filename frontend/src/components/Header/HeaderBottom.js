import React from 'react';
import { Link } from 'react-router-dom';
import { useLocation } from 'react-router';

const HeaderBottom = () => {
  const menu = [    
    {name: "Importar", link: "/"}, 
    {name: "Relatório", link: "/relatorio"}    
  ];

  

  const location = useLocation();

  return (
    <div className="header-bottom">
      <nav>
        <ul>
          {menu.map((menu, index) => 
            <li 
              key={index} 
              className={menu.link === location.pathname ? 'active' : ''}              
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
